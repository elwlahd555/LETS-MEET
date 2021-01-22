<template>
  <div id="app">
    <div class="header">
      <div class='logo'>
        <img src="../../assets/images/logo.png" 
        style="width: 70%; max-height: 50px; max-width: 200px;">

      </div>
    </div>

    <Loginform />

    <div class="footer">
      <div class="links">
        <img src="../../assets/images/snsLogin/kakao.jpg" style='width:20%; border-radius:50%' alt="">
        <span>구글</span>
        <span>네이버</span>
      </div>
      <a href="" style="color:slateGray">비밀번호 찾기</a>
      <a href="" style="color:slateGray">회원가입</a>
    </div>
  </div>
</template>

<script>
import Loginform from "../../components/user/Loginform";

export default {
  name: "Login",
  components: {
    Loginform,
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
</style>
