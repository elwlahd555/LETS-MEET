<template>
  <div class='p-3'>
    <v-form ref='form'>
    <!-- <v-card-title class="pb-0">
        <h5 >로그인</h5>
    </v-card-title> -->
    <v-card-text>
        <v-text-field 
            ref ='email'
            v-model="user.email"
            label="이메일" 
            prepend-icon="email"
            :rules="[rules.required, rules.email]"
        />
        <v-text-field 
            ref ='password'
            v-model="user.password"
            :type="showPassword ? 'text' : 'password'"
            :rules="[rules.required, rules.min]"
            label="비밀번호"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
        />
 
    </v-card-text>
    <mdb-btn gradient="peach" rounded>n</mdb-btn>
    <v-card-actions>
        <v-btn @click='loginsubmit' color="success" rounded style='width:100%'>Login</v-btn>
    </v-card-actions>
    </v-form>
  </div>
</template>


<script>
import { mdbBtn } from 'mdbvue';

export default {
    name: 'LoginForm',

    components: {
      mdbBtn
    },
    methods: {
      loginsubmit() { 
        // 이메일, 비번 다 기입했는지 확인 
        if (this.$refs.form.validate()) {
          this.$store
          .dispatch('LOGIN', this.user) 
          .then(() => { 
            console.log('로그인 성공')
            })
          .catch(() => { alert('로그인 실패 ')})

        }
        // Object.keys(this.$refs).forEach(f => {
        //   console.log(this.$refs[f].$options)
          // if (!this.$refs[f].) this.formHasErrors = true
          // this.$refs[f].validate(true)
        // })
      }
    },
    data: () => {
        return {
          user : {
            email: '',
            password: '',
          },
            showPassword: false,
            formHasErrors: false,
            rules: {
              required: value => !!value,
              counter: value => value.length <= 20 || '최대 20자까지 가능합니다.',
              email: value => { 
                const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                return pattern.test(value) || '이메일 형식이 아닙니다.'
            },
          }
      }
    }

}

</script>
<style scoped>

</style>