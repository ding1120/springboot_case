new Vue({
    el: "#userList", //定义一个变量
    data: {
        userList: []    //用户列表
    },
    methods: {
        findAll: function () {
            var url = "http://localhost:8080/user/findAll"; //相应数据从这个地址中获取
            var _this = this;
            //发送异步请求获取所有用户数据
            axios.get(url).then(function (response) {
                //console.log(response);
                if(!response.data.status){
                    alert(response.msg);
                    return ;
                }
                _this.userList = response.data.data;//响应成功有数据,数据是什么？
            });
        }
    },
    created(){
        this.findAll();
    }
});