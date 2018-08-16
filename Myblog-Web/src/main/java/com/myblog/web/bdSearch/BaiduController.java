package com.myblog.web.bdSearch;

import com.myblog.util.JsoupHandleResult;
import com.myblog.util.ResponseUtil;
import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * /**
 *
 * @author: wuci
 * @date: 2018/7/19
 * @copyright:zjkj
 * @since : v 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/bd")
public class BaiduController {
     private final Logger LOG = Logger.getLogger(BaiduController.class);
    @RequestMapping(value = "/getSearch", method = RequestMethod.POST)
    public ResponseEntity<String> getSearchContent(String searchCondition, Long page) {
        LOG.info("请求进来了:参数为searchCondition："+searchCondition+"、page:"+page);
        return ResponseUtil.createResponseEntity(JsoupHandleResult.getBaiduResult(searchCondition,page).toString());
    }
}
