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
              label="이름"
              :rules="[rules.required]"
              prepend-icon="mdi-account-circle"
              type='text'
              @keyup.enter='submit'
            >
            </v-text-field>
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
            
            
          </v-card-text>

            <v-card-actions>
                <v-btn color="teal" rounded style='width:100%' @click="submit">회원가입</v-btn>
            </v-card-actions>
          <v-card-actions class="pt-3 px-3">
              <router-link class="ro" :to="{ name: 'Login' }"><v-icon large>mdi-arrow-left-circle</v-icon></router-link>
          </v-card-actions>
    </v-form>
    </div>
</template>
<script>
const axios = require('axios');

export default {
    name: 'UserInfoChange',
    data: () => {
      return  {
        user: {
          uEmail : '',
          uPassword: '',
          uName: '',
        },
        passwordConfirm: '',
        showPassword: false,
        showPassword2: false,
        SignupFormHasError: false,
        rules: {
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
        passwordCheck () { 
          return () => (this.user.uPassword === this.passwordConfirm) || '비밀번호가 일치하지 않습니다.'
          // return () => (this.user.uPassword === this.passwordConfirm) || '비밀번호가 일치하지 않습니다.'
        },
    },
    methods: {
      submit () {
        console.log('???')
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