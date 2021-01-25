<template>
  <div class='p-3'>
    <v-form ref='form'>
    <!-- <v-card-title class="pb-0">
        <h5 >로그인</h5>
    </v-card-title> -->
    <v-card-text>
        <v-text-field 
            ref ='email'
            v-model="email"
            label="이메일" 
            prepend-icon="email"
            :rules="[rules.required, rules.email]"
        />
        <v-text-field 
            ref ='password'
            v-model="password"
            :type="showPassword ? 'text' : 'password'"
            :rules="[rules.required, rules.min]"
            label="비밀번호"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
        />
 
    </v-card-text>
    <v-card-actions>
        <v-btn @click='submit' color="success" rounded style='width:100%'>Login</v-btn>
    </v-card-actions>
    </v-form>
  </div>
</template>


<script>
// import PV from "password-validator";


export default {
    name: 'Loginform',
    methods: {
      submit() { 
        // 이메일, 비번 다 기입했는지 확인 
        if (!this.$refs.form.validate()) return console.log('다 안채워짐')
        else console.log('확인')
        // Object.keys(this.$refs).forEach(f => {
        //   console.log(this.$refs[f].$options)
          // if (!this.$refs[f].) this.formHasErrors = true
          // this.$refs[f].validate(true)
        // })
      }
    },
    data: () => {
        return {
            email: '',
            password: '',
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