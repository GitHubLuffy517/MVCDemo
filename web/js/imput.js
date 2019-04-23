function Cmd() {
    //获取一个数组
    var ipt = document.getElementById("box").getElementsByClassName("input");
    for (var i = 0; i < ipt.length; i++) {
        if (ipt[i].value.length == 0) {
            alert("所有文本框都需要填写！")
            return false;
        }
    }
    return true;
}