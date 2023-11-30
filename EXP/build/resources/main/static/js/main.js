var iddx = 0;
let utt = "/updateFood?name=";
let ttt = "/deleteFood?name=";

$(document).ready(function(){
    let seraph = "";
    let type = 'sortbydate';
    types_query();
    function types_query() {
        $.ajax({
            type: "POST",
            url: "/" + type,
            dataType: "json",
            success: function (data) {
                datareturn(data);
            }
        });

        function datareturn(data) {
            $('#tableTable').empty();
            iddx =0;
            var table = `<table style="text-align: center">`
            table += "<tr><th>번호</th><th>이름</th><th>주소</th><th>분류</th><th>대표메뉴</th><th>등록날짜</th></tr>"
            for (var i in data) {
                table += "<tr>"
                table += "<td>" + ++iddx + "</td>"
                table += "<td>" + data[i].name + "</td>"
                table += "<td>" + data[i].addr + "</td>"
                table += "<td>" + data[i].type + "</td>"
                table += "<td>" + data[i].recommend + "</td>"
                table += "<td>" + data[i].uptime + "</td>"
                table += `<td><button type="button" class="lkj" id="`+data[i].name+`" th:style="${session.admin != null ? '' : 'display:none'}">수정</button> </td>`
               // table += `<td><button type="button" onclick="location.href='` + utt + data[i].name + `'">수정</button> </td>`
                table += `<td><button type="button" onclick="if(confirm('정말 삭제하시겠습니까?'))location.href='` + ttt + data[i].name + `'" th:style="${session.admin != null ? '' : 'display:none'}">삭제</button> </td>`
                table += "</tr>";

            }
            table += "</table>"
            $('#tableTable').append(table);
        }
    }
//
//
// ?name= id
    $(document).on('click','.sorttype',function(){
        type = $(this).attr("id");
        types_query();
    });

    $(document).on('click','.findaddr',function(){
        type = "findaddr?addr="+$(this).attr("id");
        types_query();
    });
    $(document).on('click','.findtype',function(){
        type = "findtype?type="+$(this).attr("id");
        types_query();
    });
    $(document).on('click','.findrecommend',function(){
        var igonanFoodRecommend = document.getElementById('searchforrecommend').value;
        if(igonanFoodRecommend ==null || igonanFoodRecommend ==''){
            alert("비어있는데");
            return false;
        }
        console.log(igonanFoodRecommend);
        type = "findrecom?name="+igonanFoodRecommend;
         types_query();
    });
    $(document).on('click','.inputCancel',function(){
        $("#name").val('');
        $("#addr").val('');
        $("#type").val('');
        $("#recommend").val('');
        $("#name").attr('disabled',false);

    });
    $(document).on('click','.lkj',function(){
       let name = $(this).attr('id');

            $.ajax({
                type: "POST",
                url: "/findname?name=" + name,
                dataType: "json",
                success: function (data) {
                    console.log(data)
                    $("#name").val(data[0].name);
                    $("#addr").val(data[0].addr);
                    $("#type").val(data[0].type);
                    $("#recommend").val(data[0].recommend);
                    $("#name").attr('disabled',false);

                }
            });
    });
});
