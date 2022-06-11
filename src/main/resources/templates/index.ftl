<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        @import url(static/css/main.css);
    </style>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/jquery-pjax/2.0.0/jquery.pjax.js"></script>
</head>
<script>

    $(document).pjax(".newInput", ".command_list", "newInput")

    // $(".ter_input").keydown(function (e) {
    //     if (e.keyCode === 13) {
    //         $("ter_input_form").submit()
    //         // 取消之前的 keydown事件
    //         e.preventDefault()
    //     }
    // })
    //
    // function formSubmit() {
    //     $("ter_input_form").on('submit()', function (e) {
    //         e.stopPropagation();
    //         e.preventDefault();
    //     })
    // }

</script>
<body>
<div class="main_container">
    <div class="terminal">
        <div class="command_list">
            <#list sections as section>
                <secion class="item">
                    <p class="prompt">${section.prompt}</p>
                    <p class="previous_input">${section.previousInput}</p>
                    <p class="previous_output">${section.previousOutput}</p>
                </secion>
            </#list>
        </div>
        <p class="prompt"># guest in ~/</p>
        <form id="ter_input_form" action="/terminal_input">
            <input name="newInput" class="new_input" type="text"
                   maxlength="20">
        </form>
    </div>
</div>
</body>
</html>