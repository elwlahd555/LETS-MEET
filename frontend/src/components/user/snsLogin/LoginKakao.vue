<template>
    <img
        class="kakao_btn"
        src="@/assets/images/snsLogin/kakao.jpg" style='width:13%;' alt=""
        @click="loginWithKakao"
    />
</template>

<script>
export default {
    name: "LoginKakao",
    methods: {
        loginWithKakao() {
            const params = {
                redirectUri: "http://localhost:8080/kakaocallback",
            };
            window.Kakao.Auth.authorize(params);
        },
    },
};
</script>