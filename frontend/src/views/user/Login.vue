<template>
  <div id="app">
    <div class="header">
      <div class='logo'>
        <img src="../../assets/images/logo.png" 
        style="width: 70%; max-height: 50px; max-width: 200px;">

      </div>
    </div>

    <LoginForm />

    <div class="footer">
      <div>
        <img src="../../assets/images/snsLogin/kakao.jpg" style='width:13%;' alt="">
        <img src="../../assets/images/snsLogin/google.png" style='width:13%;' alt="">
        <img src="../../assets/images/snsLogin/naver.png" style='width:13%;' alt="">
      </div>
      <a href="" style="color:slateGray">비밀번호 찾기</a>
      <router-link :to="{ name: 'Signup' }" style="color:slateGray">회원가입</router-link>
    </div>
  </div>
</template>

<script>
import LoginForm from "../../components/user/LoginForm";

export default {
  name: "Login",
  components: {
    LoginForm,
  }
};
</script>

<style lang="scss">
#app {
  color: #2c3e50;
  margin: 0;
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.footer,
.header {
  padding: 20px 20px;
  color: #f0f4f8;
  display: flex;
  flex-direction: column;
  align-items: center;
  h1,
  h2,
  h3 {
    padding: 0;
    margin: 0;
  }
}

.header {
  padding: 10px 20px;
  .logo {
    text-align: center;
    font-family: "Open Sans";
    letter-spacing: 3px;
    padding-top: 15px;
    padding-bottom: 15px;
  }
  .logo .part-2 {
    color: #d64545;
  }
}
.footer > div {
  display: flex;
  justify-content: space-around;
  padding-bottom: 15px;
  margin-bottom: 15px;
}
</style>
