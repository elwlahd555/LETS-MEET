import axios from '@/services/axios';

const kakaoHeader = {
    'Authorization': 'c7f41dd3c6ebfe77ee6ffffa6e688c9b',
    'Content-type': 'application/x-www-form-urlencoded;charset=utf-8',
};
const getKakaoToken = async (code) => {
    console.log('loginWithKakao');
    try {
        const data = {
            grant_type: 'authorization_code',
            client_id: 'deace353f1fd1555201a07f914bc5598',
            redirect_uri: 'http://i4d107.p.ssafy.io/kakaocallback',
            code: code,
        };
        const queryString = Object.keys(data)
            .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(data[k]))
            .join('&');
        const result = await axios.post('https://kauth.kakao.com/oauth/token', queryString, { headers: kakaoHeader });
        console.log('카카오 토큰', result);
        return result;
    } catch (e) {
        return e;
    }
};
const getKakaoUserInfo = async () => {
    let data;
    await window.Kakao.API.request({
        url: "/v2/user/me",
        success: function (response) {
            data = response;
        },
        fail: function (error) {
            console.log(error);
        },
    });
    console.log('카카오 계정 정보', data);
    return data;
};
export {
    getKakaoToken,
    getKakaoUserInfo,
};