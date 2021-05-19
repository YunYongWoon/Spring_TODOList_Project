package controller;

import com.nhncorp.lucy.security.xss.XssSaxFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XssTestController {
    @RequestMapping(value = "/xsstest", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> xssEscapeTest() {
        // given
        String dirty = "<script>alert('dirty');</script>";

        // when
        System.out.println(dirty);
        String clean = XssSaxFilter.getInstance().doFilter(dirty);
        System.out.println(dirty);
        System.out.println(clean); // <!-- Not Allowed Tag Filtered -->&lt;script&gt;alert('dirty');&lt;/script&gt;
        clean = clean.replace("<!-- Not Allowed Tag Filtered -->\n", "");
        System.out.println(clean); // &lt;script&gt;alert('dirty');&lt;/script&gt;
        return new ResponseEntity<String>(clean, HttpStatus.OK);
    }
}
