webpackJsonp([1],{"+8Oy":function(e,t){},"6hNu":function(e,t){},"E/sP":function(e,t){},SFGZ:function(e,t,n){"use strict";n.d(t,"d",function(){return o}),n.d(t,"b",function(){return i}),n.d(t,"e",function(){return r}),n.d(t,"f",function(){return l}),n.d(t,"a",function(){return s}),n.d(t,"c",function(){return a});var o=function(e,t){var n="";return n=Math.ceil(1e14*Math.random()).toString().substr(0,e||4),t&&(n+=Date.now()),n},i=function(e,t){0!==t.length&&e.addRoutes(formatRoutes(t))},r=function(e,t){var n=e;if(-1!==e.indexOf("#")&&-1===e.indexOf("http")){var o=n.substr(n.indexOf(":"));n="/myiframe/urlPath?src="+baseUrl+o+n.replace("#","").replace(o,"")+"}&name="+t}else n=-1!==e.indexOf("http")?"/myiframe/urlPath?src="+n+"&name="+t:""+n;return n},l=function(e){return e.query.src?e.query.src:e.path},s=function(){c()?m():u()},a=function(e){function t(){e()}document.addEventListener("fullscreenchange",function(e){t()}),document.addEventListener("mozfullscreenchange",function(e){t()}),document.addEventListener("webkitfullscreenchange",function(e){t()}),document.addEventListener("msfullscreenchange",function(e){t()})},c=function(){return document.fullscreenEnabled||window.fullScreen||document.mozFullscreenEnabled||document.webkitIsFullScreen},u=function(){document.documentElement.requestFullScreen?document.documentElement.requestFullScreen():document.documentElement.webkitRequestFullScreen?document.documentElement.webkitRequestFullScreen():document.documentElement.mozRequestFullScreen&&document.documentElement.mozRequestFullScreen()},m=function(){document.documentElement.requestFullScreen?document.exitFullScreen():document.documentElement.webkitRequestFullScreen?document.webkitCancelFullScreen():document.documentElement.mozRequestFullScreen&&document.mozCancelFullScreen()}},flBG:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n("Dd8w"),i=n.n(o),r=n("SFGZ"),l=n("NYxO"),s=n("a7Hp"),a={name:"userlogin",data:function(){return{loginForm:{loginStr:"admin",password:"123456",captcha:"",remember:!1},code:{src:"",len:4,type:"text"},loginRules:{loginStr:[{required:!0,message:"请输入账号",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:6,message:"密码长度最少为6位",trigger:"blur"}],captcha:[{required:!0,message:"请输入验证码",trigger:"blur"},{min:4,max:4,message:"验证码长度为4位",trigger:"blur"}]},passwordType:"password"}},created:function(){this.refreshCode()},computed:i()({},Object(l.b)(["defaultHomePage"])),methods:{refreshCode:function(){var e=Object(r.d)(this.code.len,!0);this.code.src="http://123.207.242.177/api/admin/tool/captcha?randomStr="+e},showPassword:function(){""===this.passwordType?this.passwordType="password":this.passwordType=""},handleLogin:function(){var e=this;this.$refs.loginForm.validate(function(t){t&&e.$store.dispatch("LoginByUsername",e.loginForm).then(function(){e.$store.dispatch("SetPageState",e.defaultHomePage),e.$router.push({path:e.defaultHomePage.path})}).catch(function(t){console.log(t),s.a.error("验证码错误"),e.refreshCode()})})}}},c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{"status-icon":"",rules:e.loginRules,model:e.loginForm,"label-width":"0"}},[n("el-form-item",{attrs:{prop:"loginStr"}},[n("el-input",{attrs:{size:"small","auto-complete":"off",placeholder:"用户名 | 邮箱 | 手机号"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}},model:{value:e.loginForm.loginStr,callback:function(t){e.$set(e.loginForm,"loginStr",t)},expression:"loginForm.loginStr"}},[n("i",{staticClass:"iconfont icon-user",attrs:{slot:"prefix"},slot:"prefix"})])],1),e._v(" "),n("el-form-item",{attrs:{prop:"password"}},[n("el-input",{attrs:{size:"small",type:e.passwordType,"auto-complete":"off",placeholder:"密码"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}},[n("i",{staticClass:"iconfont icon-eye",attrs:{slot:"suffix"},on:{click:e.showPassword},slot:"suffix"}),e._v(" "),n("i",{staticClass:"iconfont icon-password",attrs:{slot:"prefix"},slot:"prefix"})])],1),e._v(" "),n("el-form-item",{attrs:{prop:"captcha"}},[n("el-row",{attrs:{span:24}},[n("el-col",{attrs:{span:12}},[n("el-input",{attrs:{size:"small",maxlength:e.code.len,"auto-complete":"off",placeholder:"请输入验证码"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}},model:{value:e.loginForm.captcha,callback:function(t){e.$set(e.loginForm,"captcha",t)},expression:"loginForm.captcha"}},[n("i",{staticClass:"iconfont icon-yanzhengma",attrs:{slot:"prefix"},slot:"prefix"})])],1),e._v(" "),n("el-col",{attrs:{span:12}},[n("div",{staticClass:"login-code"},[n("img",{attrs:{src:e.code.src},on:{click:e.refreshCode}})])])],1)],1),e._v(" "),n("el-checkbox",{model:{value:e.loginForm.remember,callback:function(t){e.$set(e.loginForm,"remember",t)},expression:"loginForm.remember"}},[e._v("记住账号")]),e._v(" "),n("el-form-item",[n("el-button",{staticClass:"login-submit",attrs:{type:"primary",size:"small"},nativeOn:{click:function(t){return t.preventDefault(),e.handleLogin(t)}}},[e._v("登录")])],1)],1)},staticRenderFns:[]};var u=n("VU/8")(a,c,!1,function(e){n("+8Oy")},"data-v-0b1f038e",null).exports,m=n("mvHQ"),d=n.n(m);function f(e){var t=[],n=!0,o="";return!function(e){if(e instanceof Array){if(0==e.length)return!0}else{if(!(e instanceof Object))return"null"==e||null==e||"undefined"==e||void 0==e||""==e;if("{}"===d()(e))return!0}return!1}(e)?11==e.length?/^0\d{2,3}-?\d{7,8}$/.test(e)?o="手机号码格式不正确":n=!1:o="手机号码长度不为11位":o="手机号码不能为空",t.push(n),t.push(o),t}var p={name:"codelogin",data:function(){return{loginForm:{mobile:"",code:""},loginRules:{mobile:[{required:!0,trigger:"blur",validator:function(e,t,n){f(t)[0]?n(new Error(f(t)[1])):n()}}],code:[{required:!0,trigger:"blur",validator:function(e,t,n){4!==t.length?n(new Error("请输入4位数的验证码")):n()}}]}}},props:[],methods:{handleLogin:function(){}}},g={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{"status-icon":"",rules:e.loginRules,model:e.loginForm,"label-width":"0"}},[n("el-form-item",{attrs:{prop:"mobile"}},[n("el-input",{attrs:{size:"small","auto-complete":"off",placeholder:"手机号码"},model:{value:e.loginForm.mobile,callback:function(t){e.$set(e.loginForm,"mobile",t)},expression:"loginForm.mobile"}},[n("i",{staticClass:"iconfont icon-shouji",attrs:{slot:"prefix"},slot:"prefix"})])],1),e._v(" "),n("el-form-item",{attrs:{prop:"code"}},[n("el-row",{attrs:{span:24}},[n("el-col",{attrs:{span:14}},[n("el-input",{attrs:{size:"small","auto-complete":"off",placeholder:"验证码"},model:{value:e.loginForm.code,callback:function(t){e.$set(e.loginForm,"code",t)},expression:"loginForm.code"}},[n("i",{staticClass:"iconfont icon-yanzhengma",staticStyle:{"margin-top":"10px"},attrs:{slot:"prefix"},slot:"prefix"})])],1),e._v(" "),n("el-col",{attrs:{span:10}},[n("div",{staticClass:"msg-text"},[e._v("发送验证码")])])],1)],1),e._v(" "),n("el-form-item",[n("el-button",{staticClass:"login-submit",attrs:{type:"primary",size:"small"}},[e._v("登录")])],1)],1)},staticRenderFns:[]};var h={name:"login",data:function(){return{activeName:"user"}},components:{userLogin:u,codeLogin:n("VU/8")(p,g,!1,function(e){n("E/sP")},"data-v-8e90adf0",null).exports}},v={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"login"},[n("div",{staticClass:"background"},[n("div",{staticClass:"login-container",nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}}},[e._m(0),e._v(" "),n("div",{staticClass:"login-border  animated fadeInRight"},[n("div",{staticClass:"login-main"},[e._m(1),e._v(" "),n("el-tabs",{model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[n("el-tab-pane",{attrs:{label:"账号密码",name:"user"}},[n("userLogin")],1),e._v(" "),n("el-tab-pane",{attrs:{label:"短信验证码",name:"code"}},[n("codeLogin")],1)],1)],1)])]),e._v(" "),e._m(2)])])},staticRenderFns:[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"login-info text-white animated fadeInLeft"},[n("h2",{staticClass:"login-info-title"},[e._v("千寻---通用web系统---后台登录")]),e._v(" "),n("ul",{staticClass:"login-info-list"},[n("li",{staticClass:"login-info-item"},[n("i",{staticClass:"el-icon-check"}),e._v(" 是一个基于Spring Boot、spring security开发基于Vue前后分离的开发平台\n          ")]),e._v(" "),n("li",{staticClass:"login-info-item"},[n("i",{staticClass:"el-icon-check"}),e._v(" 是一个基于vue+vuex+vue-router快速后台管理系统，采用token交互验证方式。\n          ")]),e._v(" "),n("li",{staticClass:"login-info-item"},[n("i",{staticClass:"el-icon-check"}),e._v(" 最大程度上帮助企业节省时间成本和费用开支。\n          ")]),e._v(" "),n("li",{staticClass:"login-info-item"},[n("i",{staticClass:"el-icon-check"}),e._v(" 当前版本：v1.0.0\n          ")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("h4",{staticClass:"login-title"},[t("span",[this._v("千寻-后台登录")])])},function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"bottom-block"},[t("span",[this._v("@cloudyslife.cn")]),this._v(" "),t("a",{attrs:{target:"_blank",href:"http://www.miitbeian.gov.cn"}},[this._v(" 渝ICP备17009677号-1 ")]),this._v(" "),t("span",[this._v("邮箱: 314705487@qq.com")])])}]};var b=n("VU/8")(h,v,!1,function(e){n("6hNu")},null,null);t.default=b.exports}});
//# sourceMappingURL=1.3ebd7493a72341b9fbf9.js.map