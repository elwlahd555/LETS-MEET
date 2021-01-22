<template>
    <div width="400">
    <v-card-title class="pb-0">
        <!-- <h5 >로그인</h5> -->
    </v-card-title>
    <v-card-text>
        <v-form>
        <v-text-field 
            label="Username" 
            prepend-icon="mdi-account-circle"
        />
        <v-text-field 
            :type="showPassword ? 'text' : 'password'" 
            label="Password"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
        />
        </v-form>   
    </v-card-text>
    <v-card-actions>
        <v-btn color="info" rounded style='width:100%'>Login</v-btn>
    </v-card-actions>
    </div>
</template>


<script>
export default {
    name: 'Loginform',
}
</script>
<style scoped>
h5 {
    text-align: center;
    font-weight: bold;

}
</style>