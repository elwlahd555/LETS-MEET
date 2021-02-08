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
              label="이름"
              prepend-icon="mdi-account-circle"
              type='text'
              @keyup.enter='submit'
            >
            </v-text-field>
            
          <v-file-input
              accept="image/*"
              label="이미지 등록"
              v-model='uImageId'
            ></v-file-input>
          </v-card-text>

          <!-- 비밀번호 변경부분 -->
             <v-row class='px-5 mb-5'>
                <v-dialog
                  v-model="dialog1"
                  persistent
                  max-width="400"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <div class='pt-1 px-3' v-bind="attrs" v-on="on">
                      <v-icon>mdi-lock</v-icon>
                      <h6 class='d-inline'>&nbsp;&nbsp;&nbsp;비밀번호 변경</h6>
                    </div>
                  </template>

                  <v-card class="p-3">
                    <v-container>
                      <v-row>
                        <v-text-field 
                          label='현재 비밀번호'
                          v-model="nowpw"
                          @keyup="nowpwcheck"
                          :rules="[NowPasswordCheck]"
                          :type="showPassword1 ? 'text' : 'password'"
                          append-icon="showPassword1 ? 'mdi-eye' : 'mdi-eye-off'"
                          @click:append="showPassword1 = !showPassword1"
                          >
                          </v-text-field>
                      </v-row>
                      <v-row>
                        <v-text-field label='새 비밀번호'
                            ref='newPassword'
                            v-model="user.uPassword"
                            :rules="[rules.required, NewPasswordCheck]"
                            :type="showPassword2 ? 'text' : 'password'"
                            :append-icon="showPassword2 ? 'mdi-eye' : 'mdi-eye-off'"
                            @click:append="showPassword2 = !showPassword2"
                          
                          >
                          </v-text-field>
                      </v-row>
                      <v-row>
                           <v-text-field 
                            label='비밀번호 다시 입력'
                            v-model="newpasswordconfirm"
                            :rules="[rules.required, NewDoublePasswordCheck]"
                            :type="showPassword3 ? 'text' : 'password'"
                            :append-icon="showPassword3 ? 'mdi-eye' : 'mdi-eye-off'"
                            @click:append="showPassword3 = !showPassword3"
                            >

                          </v-text-field>
                      </v-row>
                    </v-container>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        color="green darken-1"
                        text
                        @click="dialog1 = false"
                      >
                        Disagree
                      </v-btn>
                      <v-btn
                        color="green darken-1"
                        text
                        @click="dialog1 = false"
                      >
                        Agree
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-row>

            <div class= 'd-flex justify-end px-3'>
              <v-dialog
                v-model="dialog2"
                persistent
                max-width="290"
              >
                <template v-slot:activator="{ on, attrs }">
                  <div v-on="on" v-bind="attrs" style="font-size: 14px;">
                    회원 탈퇴 
                  </div>
                </template>
                <v-card>
                  <v-card-title class="headline">
                    회원 탈퇴
                  </v-card-title>
                  <v-card-text>letsmeet 서비스를 이용하시는데 불편함이 있으셨나요? 이용 불편 및 각종 문의 사항은 고객센터로 문의 주시면 성심 성의껏 답변 드리겠습니다.</v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                      color="green darken-1"
                      text
                      @click="dialog = false"
                    >
                      아니요
                    </v-btn>
                    <v-btn
                      color="green darken-1"
                      text
                      @click="deleteUser"
                    >
                      예
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </div>

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
const config = {
          headers: { 'auth-token': window.localStorage.getItem('auth-token') },
      }

export default {
    name: 'UserInfoChange',
    data: () => {
      return  {
        uImageId: '',
        user: {
          uEmail : "",
          uPassword: '',
          uName: '',
        },
        dialog1: false,
        dialog2: false,
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
      this.user.uEmail = this.$store.state.uEmail
      this.user.uName= this.$store.state.uName
      let token = localStorage.getItem('auth-token')
      let decode = jwt_decode(token); 
      this.beforepw = decode.user.uPassword
    },

    methods: {
      nowpwcheck() {

      },
      passwordchange(){
        return this.passwordModify=!this.passwordModify;
      },
      modifyinfo () {
        if (this.user.uPassword === '') {
          this.user.uPassword = this.beforepw
        }
        // 회원정보 수정 uEmail 에서 userid로 바꿀 예정 
        axios.put(`http://localhost:8000/letsmeet/user/mypage/${this.user.uEmail}`, this.user, config )
            .then(()=> {
              alert('회원정보 수정이 되었습니다.')
              this.$store.dispatch('FETCH_USER_NAME', this.user.uName);
              this.$store.dispatch('FETCH_USER_IMAGE', this.uImageId);
              this.$router.replace({ name: 'MyPage'})
            })
            .catch(() => {
              alert('회원정보 수정이 실패하였습니다.')
            })
      },
      deleteUser() {
        if (this.user.uPassword === '') {
          this.user.uPassword = this.beforepw
        }
        const userdelete = { uEmail: this.user.uEmail, uPassword:  this.user.uPassword}
        axios.delete(`http://localhost:8000/letsmeet/user/delete/${this.user.uEmail}`, userdelete, config)
        .then(()=> {
          alert('회원 탈퇴가 되었습니다.')
          this.$store.dispatch('DELETE_ACCOUNT')
          this.$router.replace({ name: 'Login' })

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