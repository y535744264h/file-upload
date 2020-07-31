/**
 * 通用js方法封装处理
 */
(function ($) {
    $.extend({
        upUpload:{},
        fileUpload: {
            _option: {},
            // 初始化表格参数
            init: function (options) {
                var defaults={
                    url: "/files/uploading",
                    autoProcessQueue: false,
                    dictDefaultMessage: "拖入需要上传的文件"
                }
                var options = $.extend(defaults, options);
                $.fileUpload._option = options;
                $.upUpload=$("#"+options.target);
                var uppy = Uppy.Core()
                    .use(Uppy.Dashboard, {
                        inline: true,
                        target: '#'+options.target
                    });


            }
        }
    });
})(jQuery);

