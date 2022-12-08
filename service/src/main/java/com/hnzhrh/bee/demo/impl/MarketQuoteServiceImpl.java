package com.hnzhrh.bee.demo.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.*;
import com.hnzhrh.bee.demo.api.MarketQuoteServiceI;
import com.hnzhrh.bee.domain.entity.MarketQuote;
import com.hnzhrh.bee.domain.mapper.MarketQuoteMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class MarketQuoteServiceImpl implements MarketQuoteServiceI {

    private static final int MAX_HANDLE_ROW = 10000;

    @Resource
    private MarketQuoteMapper marketQuoteMapper;

    /**
     * 在这个定时场景下，个人认为1个G的文件直接读到内存里面如果是单服务应该戳戳有余
     * 如果不行可以分行数去读，注释代码部分，直到读出来为空为止
     */
    @Override
    public void loadData() {
//        分多行去读
//        CsvReadConfig config = new CsvReadConfig();
//        config.setBeginLineNo(0);
//        config.setEndLineNo()
        CsvReader reader = CsvUtil.getReader();
        reader.setContainsHeader(true);
        CsvData csvData = null;
        try {
            csvData = reader.read(FileUtil.file(ResourceUtils.getFile("classpath:file/market_quote.csv")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件读取失败！");
        }
        List<CsvRow> rows = csvData.getRows();
        List<MarketQuote> datas = new ArrayList<>();
        for (CsvRow row : rows) {
            datas.add(this.convert(row));
        }
        // 切分数据
        List<List<MarketQuote>> splits = CollUtil.split(datas, MAX_HANDLE_ROW);
        CountDownLatch countDownLatch = new CountDownLatch(rows.size() / MAX_HANDLE_ROW + 1);
        for (List<MarketQuote> split : splits) {
            new Thread(() -> {
                if (split.size() > 1) {
                        marketQuoteMapper.insertBatchSomeColumn(split);
                } else if (split.size() == 1) {
                        marketQuoteMapper.insert(split.get(0));
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("线程异常！");
        }
    }

    private MarketQuote convert(CsvRow csvRow) {
        MarketQuote marketQuote = new MarketQuote();
        marketQuote.setCurveName(csvRow.getByName("CURVENAME"));
        marketQuote.setInstrumentType(csvRow.getByName("INSTRUMENTTYPE"));
        marketQuote.setInstrumentName(csvRow.getByName("INSTRUMENTNAME"));
        marketQuote.setTenor(csvRow.getByName("TENOR"));
        marketQuote.setQuote(csvRow.getByName("QUOTE"));
        marketQuote.setMaturityDate(csvRow.getByName("MATURITYDATE"));
        marketQuote.setMHPerDate(csvRow.getByName("M_H_REP_DATE"));
        marketQuote.setIsDeleted(0);
        marketQuote.setGmtCreated(LocalDateTime.now());
        marketQuote.setGmtModified(LocalDateTime.now());
        return marketQuote;
    }
}
