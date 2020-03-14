 $("#commitOrder").click(
        function() {
          var receiverId = $("#defaultReceiver").data("id");
          var pargrams = '';
          var payDiv;
          var totalAmount = $('#totalAmount').html();
          $("#productList").find('.productCount').each(function() {
            var $this = $(this);
            var id = $this.data("id");
            var count = $this.data("count");
            var pargram = id + "_" + count;
            pargrams += pargram + ",";// 遍历选中的checkbox
          });
          if (receiverId === null) {
            toastr.warning('请先设置默认联系人！');
          } else {
            $.post(g_rootPath + "/front/order/payments/" + pargrams + "/" + receiverId, function(data) {
              $("html").html(data);
            });
          }

        });