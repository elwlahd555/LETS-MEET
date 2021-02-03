<template>
    <div>
        <div>test</div>
    </div>
</template>

<script>
import { getKakaoToken, getKakaoUserInfo, naverService } from "@/services/kakaoLogin";
export default {
    name: 'KakaoCallback',
    created() {
        if (this.$route.query.code) {
            this.setKakaoToken();
        }
    },
    mounted() {
        if (this.$route.hash) {
            naverService().getUserInfo();
        }
    },
    methods: {
        async setKakaoToken () {
            console.log('카카오 인증 코드', this.$route.query.code);
            const { data } = await getKakaoToken(this.$route.query.code);
            if (data.error) {
                alert('카카오톡 로그인 오류입니다.');
                this.$router.replace('/login');
                return;
            }
            window.Kakao.Auth.setAccessToken(data.access_token);
            this.$cookies.set('access-token', data.access_token, '1d');
            this.$cookies.set('refresh-token', data.refresh_token, '1d');
            await this.setUserInfo();
            this.$router.replace('/');
        },
        async setUserInfo () {
            getKakaoUserInfo();
            // 여기에 백으로 계정 정보 넘겨주면 된다.
        },
        getInfo() {
            naverService().getUserInfo();
        }
    }
}
</script>