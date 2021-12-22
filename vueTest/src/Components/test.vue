<template>
  <div>
        <form action="#" method="post">
            <label for="id">아이디</label>
            <input type="text" for="id" name="id">
            <br>
            <label for="password">비밀번호</label>
            <input type="password" for="password" name="password">
            <br>
            <input type="submit" value="로그인" onclick="login()">
            <input type="button" value="회원가입">
        </form>
    </div>
</template>

<script>
export default {
    
}
</script>