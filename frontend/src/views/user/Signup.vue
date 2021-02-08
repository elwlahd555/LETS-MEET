<template>
  <div>
    <v-form ref='form'>
      <v-card-title>
        회원가입
      </v-card-title>
        <v-card-text>
            <v-text-field
              ref='email'
              v-model='user.uEmail'
              label ='이메일'
              prepend-icon="email"
              :rules="[rules.required, rules.email, dodo]"
              required
              >
            </v-text-field>
            
            <!-- 이메일 인증 팝업창 -->
            <v-row justify="end" class="px-4 py-1">
              <v-dialog
                  v-model="dialog"
                  persistent
                  max-width="290"
                >
                  <template v-slot:activator="{ on, attrs }">
                      <v-btn id ='dupid' text @click='dupchch'> 중복 </v-btn>
                      <v-btn id ='dupauth' class="pt-0 px-1" v-bind="attrs" v-on="on" text> 인증 </v-btn>                    
                      <!-- <div style="color:#3949AB" v-bind="attrs" v-on="on" >이메일 인증</div> -->
                  </template>
  
                  <v-card>
                    <div class="text-center p-3" style="font-size:20px;">
                      이메일 인증
                    </div>
                    
                    <v-text-field class="px-4 pt-0" v-model="authCode" @keypress.enter="authCodeCheck">
                    </v-text-field>
                      <!-- <v-icon class="d-flex-inline">mdi-check</v-icon> -->
                      <div class="px-5 pt-0 text-end" @click ="sendCode(user.uEmail)" style="font-size:14px; color:#546E7A;">
                        인증코드 보내기
                      </div>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        color="green darken-1"
                        text
                        @click="disagree"
                      >
                        취소
                      </v-btn>
                      <v-btn
                        color="green darken-1"
                        text
                        :disabled='authCodeIsRight'
                        @click="agree"
                      >
                        확인
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-row>
            
            
            
            
            <v-text-field
              ref='password'
              v-model="user.uPassword"
              label="비밀번호"
              :rules="[rules.required]"
              :type="showPassword ? 'text' : 'password'"
              :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
              @click:append="showPassword = !showPassword"
              prepend-icon="mdi-lock"

            >
            </v-text-field>
            
            <v-text-field
              ref="passwordConfirm"
              v-model="passwordConfirm"
              :rules="[rules.required, passwordCheck]"
              label="비밀번호 확인"
              :type="showPassword2 ? 'text' : 'password'"
              :append-icon="showPassword2 ? 'mdi-eye' : 'mdi-eye-off'"
              @click:append="showPassword2 = !showPassword2"
              prepend-icon="mdi-lock-alert"
            >
            </v-text-field>

            <v-text-field
              ref='name'
              v-model="user.uName"
              required
              label="이름"
              :rules="[rules.required]"
              prepend-icon="mdi-account-circle"
              type='text'
              @keyup.enter='submit'
            >
            </v-text-field>

            <!-- <v-text-field
              type ='date'
              value ='1950-01-01'
              min = '1950-01-01'
              max = '2010-12-31'
              ref= 'birthdate'
              v-model="user.birthdate"
              :rules = "[rules.required]"
              label='생년원일'
              prepend-icon="mdi-calendar-range"
            >
            </v-text-field>

            <v-text-field
              type='tel'
              placeholder="010-1234-5678"
              :rules="[rules.phone]"
              ref='phone'
              v-model="user.phone"
              label='전화번호'
              prepend-icon="phone"
            >
            </v-text-field> -->
            
          </v-card-text>

            <v-card-actions>
                <v-btn color="indigo accent-2" class="text-white" rounded style='width:100%' @click="submit">회원가입</v-btn>
            </v-card-actions>
          <v-card-actions class="pt-3 px-3">
              <router-link class="ro" :to="{ name: 'Login' }"><v-icon large color="indigo accent-2">mdi-arrow-left-circle</v-icon></router-link>
          </v-card-actions>
    </v-form>
  </div>
</template>

<script>
const axios = require('axios');

export default {
    name: 'Signup',
    data: () => {
      return  {
        user: {
          uEmail : '',
          uPassword: '',
          uName: '',
        },
        dialog: false,
        passwordConfirm: '',
        showPassword: false,
        showPassword2: false,
        SignupFormHasError: false,
        emailCheck: false,
        authCodeIsRight:false,
        authCode: '',
        checkck: false,
        duplicateCh: false,
        rules: {
          // 8자 이상으로
            required: value => !!value, 
            phone: value => {
              const pattern = /[0-9]{3}-[0-9]{4}-[0-9]{4}/
              return pattern.test(value) || '휴대폰번호 형식이 아닙니다.'
            },
            // counter: value => value.length <= 20 || '최대 20자까지 가능합니다.',
            email: value => {
              const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
              return pattern.test(value) || '이메일 형식이 아닙니다.'
              },
        },
      }
    },
    computed: {
        dodo () {
          return () => (this.chch()) || '중복체크와 인증이 필요합니다.' 
        },
        passwordCheck () { 
          return () => (this.user.uPassword === this.passwordConfirm) || '비밀번호가 일치하지 않습니다.'
          // return () => (this.user.uPassword === this.passwordConfirm) || '비밀번호가 일치하지 않습니다.'
        },
    },
    methods: {
        // chch () {
        //   if ((this.duplicateCh === true) && (this.emailCheck === true)) {
        //     console.log('이거얌?')
        //     return true
        //   } else{
        //     return false
        //   }
        // },
        dupchch() {
          if (this.rules.email) {
            axios.get(`http://localhost:8000/letsmeet/user/join/check/email/${this.user.uEmail}`)
            .then((res)=> {
              const dupid = document.getElementById('dupid')
              if (res.data === false) {
                // 사용가능한 아이디
                dupid.style.color = '#3949AB'
                this.duplicateCh = true
              } else {
                dupid.style.color = 'red'
                this.duplicateCh = false
                alert('중복된 아이디입니다!')
              }

            })
            .catch((error)=> {
              console.log(error+'안됨')
            })
          }
        },
        check () {
          if (this.rules.email && this.rules.required) {
            this.checkck = true
          } 
          if (this.rules.email || this.rules.required) {
            this.checkck = false
          }
        },  
      submit () {
        console.log(this.$refs.form)
        if (this.$refs.form.validate()) {
          // sprin url 받기
          axios.post(`http://localhost:8000/letsmeet/user/join`, this.user )
            .then(()=> {
              alert('회원가입 완료되었습니다.')
              this.$router.push({ name: 'Login'});
            })
            .catch(() => {
              alert('회원가입에 실패하셨습니다.')
            })
        }
        else {
          console.log('정보가 다 안채워짐')
        }

      },
      sendCode (email) {
        axios.post(`http://localhost:8000/letsmeet/user/join/service/mail?uEmail=${email}`)
        .then(() => {
          console.log('코드 전송 성공')
          
        })
        .catch(() => {
          console.log('코드 전송 실패 ')
        })
      },
    authCodeCheck () {
      if (this.authCode.length > 0) {
        axios.post(`http://localhost:8000/letsmeet/user/join/service/verifyCode?code=${this.authCode}`)
        .then((res) => {
          if (res.data){
            this.authCodeIsRight = false
          }
          else {
            this.authCodeIsRight = true
          }
          // 일치하면 확인버튼 활성화
          // 일치하지않으면 확인버튼 활성화 x 
          // 이메일 적용 안되게 해야함. 
        })
      .catch(() => {
        console.log('불일치')
      })
      }
    },
    agree() {
      const dupauth = document.getElementById('dupauth')
      this.dialog = false
      this.emailCheck = true
      this.authCode = ''  
      dupauth.style.color = '#3949AB'
      console.log(this.emailCheck)
    },
    disagree() {
      const dupauth = document.getElementById('dupauth')
      this.dialog = false
      this.emailCheck = false
      this.authCode = ''
      dupauth.style.color = 'black'
      alert('이메일 인증이 필요합니다!')
    }
  }
}

</script>