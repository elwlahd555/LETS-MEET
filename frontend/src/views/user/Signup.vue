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
              :rules="[rules.required, rules.email]"
              required
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
                <v-btn @click='submit' color="teal" rounded style='width:100%'>회원가입</v-btn>
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