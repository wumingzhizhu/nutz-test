var chain = {
    "default" : {
        "ps" : [
              "org.nutz.mvc.impl.processor.UpdateRequestAttributesProcessor",
              "org.nutz.mvc.impl.processor.EncodingProcessor",
              "org.nutz.mvc.impl.processor.ModuleProcessor",
              "com.wumingzhizhu.nutz.mvc.LogTimeProcessor", // 直接写类名
              "org.nutz.mvc.impl.processor.ActionFiltersProcessor",
              "org.nutz.mvc.impl.processor.AdaptorProcessor",
              "org.nutz.mvc.impl.processor.MethodInvokeProcessor",
              "org.nutz.mvc.impl.processor.ViewProcessor"
          ],
        "error" : 'org.nutz.mvc.impl.processor.FailProcessor'
    }
}