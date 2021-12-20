<template>
    <div id="app">
        <productDetail></productDetail>
        <!-- <test></test> -->
    </div>
</template>

<script>
import productDetail from "./components/view/productDetail.vue";
import test from "./components/test.vue"

export default {    
    components: {
        productDetail: productDetail,
        test: test
    },
};
</script>

<style>
#app {    
    max-width: 70%;
    margin: 0 auto;
}
</style>