<template>
    <div class='userinfo pt-1'>
      <div class='justify-center' style="border-bottom:2px solid black">
        <h5>회원정보 수정</h5>
      </div>
      <!-- 이름, 비밀번호, 이미지 변경 -->
      <v-form ref='form'>
        <v-card-text>
            <v-text-field
              ref='name'
              v-model="user.uName"
              required
              :label="this.user.uName"
              prepend-icon="mdi-account-circle"
              type='text'
              @keyup.enter='submit'
            >
            </v-text-field>
            
          <v-file-input
            accept="image/*"
            label="이미지 등록"
            v-model='user.uImageid'
          ></v-file-input>

          <!-- 비밀번호 변경부분 -->
            <div @click="passwordchange" class='pt-2'>
                <v-icon>mdi-lock</v-icon>
                <h6 class='d-inline'>&nbsp;&nbsp;&nbsp;비밀번호 변경</h6>
            </div>

            <div class = 'p-2' v-if='passwordModify' style='border: 2px'>
              <v-text-field 
              label='현재 비밀번호'
              v-model="nowpw"
              :rules="[NowPasswordCheck]"
              :type="showPassword1 ? 'text' : 'password'"
              append-icon="showPassword1 ? 'mdi-eye' : 'mdi-eye-off'"
              @click:append="showPassword1 = !showPassword1"
              >

              </v-text-field>


              <v-text-field label='새 비밀번호'
                ref='newPassword'
                v-model="user.uPassword"
                :rules="[rules.required, NewPasswordCheck]"
                :type="showPassword2 ? 'text' : 'password'"
                :append-icon="showPassword2 ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword2 = !showPassword2"
               
              >
              </v-text-field>
              
              <v-text-field 
                label='비밀번호 다시 입력'
                v-model="newpasswordconfirm"
                :rules="[rules.required, NewDoublePasswordCheck]"
                :type="showPassword3 ? 'text' : 'password'"
                :append-icon="showPassword3 ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword3 = !showPassword3"
                >

              </v-text-field>
            </div>
          
          
          </v-card-text>

            <v-card-actions>
                <v-btn color="teal" rounded style='width:100%' @click="modifyinfo"> 정보 수정 </v-btn>
            </v-card-actions>
          <v-card-actions class="pt-3 px-3">
              <router-link class="ro" :to="{ name: 'MyPage' }"><v-icon large>mdi-arrow-left-circle</v-icon></router-link>
          </v-card-actions>
    </v-form>
    </div>
</template>
<script>
const axios = require('axios');
import jwt_decode from "jwt-decode";

export default {
    name: 'UserInfoChange',
    data: () => {
      return  {
        uEmail : "",
        user: {
          uPassword: '',
          uName: '',
          uImageid: '',
        },
        newPassword:'',
        beforepw: '',
        nowpw: '',
        passwordModify: false,
        newpasswordconfirm: '',
        showPassword1: false,
        showPassword2: false,
        showPassword3: false,
        rules: {
            required: value => !!value, 
            // counter: value => value.length <= 20 || '최대 20자까지 가능합니다.',
        },
      }
    },
    computed: {
      NowPasswordCheck () {
        return () => (this.beforepw === this.nowpw) || '현재 비밀번호와 일치하지 않습니다.'
      },
      NewPasswordCheck () {
        return () => (this.nowpw !== this.user.uPassword) || '이전 비밀번호와 일치합니다. 다시 입력해주세요.'
      },
      NewDoublePasswordCheck() {
        return () => (this.user.uPassword === this.newpasswordconfirm) || '비밀번호가 일치하지 않습니다.' 
      }
    },
    mounted() { 
      this.uEmail = this.$store.state.uEmail
      this.user.uName= this.$store.state.uName
      let token = localStorage.getItem('auth-token')
      let decode = jwt_decode(token); 
      this.beforepw = decode.user.uPassword
    },

    methods: {
      passwordchange(){
        this.passwordModify=true;
      },
      modifyinfo () {
        if (this.user.uPassword === '') {
          this.user.uPassword = this.beforepw
        }
        const config = {
          headers: { 'auth-token': window.localStorage.getItem('auth-token') },
          }
          // 회원정보 수정 uEmail 에서 userid로 바꿀 예정 
          axios.put(`http://localhost:8000/letsmeet/user/mypage/${this.uEmail}`, this.user, config )
            .then(()=> {
              alert('회원정보 수정이 되었습니다.')
              this.$store.dispatch('FETCH_USER_NAME', this.user.uName);
              this.$store.dispatch('FETCH_USER_IMAGE', this.user.uImageid);
              this.$router.replace({ name: 'MyPage'})
            })
            .catch(() => {
              alert('회원정보 수정이 실패하였습니다.')
            })
        


      }
    },
} 

</script>
<style scoped>
  .userinfo > div {
    display: flex;
    margin:20px;
  }
  
</style>