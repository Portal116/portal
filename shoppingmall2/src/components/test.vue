<template>
    <div class="detailTop">
        <div class="leftBox">
            <img
                class="scale-down"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
                alt="메이킹유 맨투맨/원피스/블라우스/스커트/기모바지 상품이미지"
            />

        </div>
        <div class="rightBox">
            <div class="item-topinfo item-topinfo--additional">
                <div class="item-topinfo_headline">
                    <div id="itemcase_basic">
                        <div class="box__item-title">
                            <h1 class="itemtit">
                                메이킹유 맨투맨/원피스/블라우스/스커트/기모바지
                            </h1>
                            <!--PRICE CASE -->
                            <p class="price">
                                <strong class="sale"
                                    >70<span class="unit">%</span></strong
                                >
                                <span class="price_innerwrap">
                                    <span class="price_original"
                                        >33,000<span class="unit"
                                            >원</span
                                        ></span
                                    >
                                    <strong class="price_real"
                                        >9,900<span class="unit"
                                            >원</span
                                        ></strong
                                    >
                                </span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="item_option_area">
                    <div class="form_body">
                        <div class="goods_option" id="coreGoodsOption">
                            <div class="temp_preview"></div>
                            <div class="section_option_area">
                                <h2 class="tit_options">옵션선택</h2>
                                <div class="select-item">
                                    <div
                                        class="item_options"
                                        id="optOrderComb_0"
                                    >
                                        <button class="select-item_option">
                                            <span class="txt">옵션명1</span
                                            ><span class="arr blind">열기</span>
                                        </button>
                                        <input
                                            type="hidden"
                                            value=""
                                            title="옵션명1 옵션값"
                                            option-name="옵션명1"
                                            id="optOrderCombOptValue1"
                                        />
                                        <ul
                                            class="
                                                select-itemoption-list
                                                type_list
                                            "
                                        >
                                            <!-- -->
                                            <li>
                                                <a
                                                    href="#"
                                                    data-optionNm="01_"
                                                    data-optionTitle="옵션명1"
                                                    >01_</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    href="#"
                                                    data-optionNm="02_"
                                                    data-optionTitle="옵션명1"
                                                    >02_</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    href="#"
                                                    data-optionNm="03_"
                                                    data-optionTitle="옵션명1"
                                                    >03_</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    href="#"
                                                    data-optionNm="04_"
                                                    data-optionTitle="옵션명1"
                                                    >04_</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    href="#"
                                                    data-optionNm="05_"
                                                    data-optionTitle="옵션명1"
                                                    >05_</a
                                                >
                                            </li>
                                        </ul>
                                    </div>
                                    <!-- <div
                                        class="item_options disable"
                                        id="optOrderComb_1"
                                    >
                                        <button class="select-item_option">
                                            <span class="txt">옵션명2</span
                                            ><span class="arr blind">열기</span>
                                        </button>
                                        <input
                                            type="hidden"
                                            value=""
                                            title="옵션명2 옵션값"
                                            option-name="옵션명2"
                                            id="optOrderCombOptValue2"
                                        />
                                        <ul
                                            class="
                                                select-itemoption-list
                                                type_list
                                            "
                                        >
                                        </ul>
                                    </div> -->
                                    <input
                                        type="hidden"
                                        value=""
                                        combname=""
                                        id="optOrderCombOptNm_0"
                                    />
                                    <input
                                        type="hidden"
                                        value=""
                                        id="optOrderCombOptNo_0"
                                    />
                                    <input
                                        type="hidden"
                                        value=""
                                        id="optOrderCombOptPrice_0"
                                    />
                                    <input
                                        type="hidden"
                                        value=""
                                        combname=""
                                        id="optOrderCombOptValue_0"
                                    />
                                    <input
                                        type="hidden"
                                        value=""
                                        combname=""
                                        id="optOrderCombOptValueTwo_0"
                                    />
                                    <input
                                        type="hidden"
                                        value=""
                                        id="optOrderCombOptVersionChgDt_0"
                                    />
                                </div>
                            </div>
                        </div>

                        <div
                            class="section_seleted_list"
                            id="coreSelectedList"
                            style="display: none"
                        >
                            <ul class="selected-list"></ul>
                        </div>
                    </div>
                    <div class="form_bottom">
                        <p
                            class="total"
                            id="coreTotalPriceP"
                            style="visibility: hidden"
                        >
                            <span class="tit"
                                >총 상품금액<a
                                    href="#tooltip_priceguide"
                                    class="open_tooltip_priceguide"
                                    ><i class="icon i_question"
                                        >총 상품금액 안내 레이어 보기</i
                                    ></a
                                ></span
                            >
                            <strong class="price" id="coreTotalPrice"
                                >0<span class="unit">원</span></strong
                            >
                        </p>
                        <div class="section_bottombtns">
                            <button
                                class="btn_primary btn_white btn_mycart"
                                data-href="#layer_mycart"
                                data-montelena-acode="200000516"
                                id="coreAddCartBtn"
                                onclick="pdsClickLog('200000516', 'utlity', {});"
                            >
                                <em>장바구니</em>
                            </button>
                            <button
                                class="btn_primary btn_blue"
                                id="coreInsOrderBtn"
                                data-montelena-acode="200000517"
                                onclick="pdsClickLog('200000517', 'utlity', {});"
                            >
                                <em>구매하기</em>
                            </button>
                        </div>
                        <div class="tooltip_priceguide tooltip_layer">
                            <div class="arrowtop_tooltip">
                                <h4 class="tit_tooltip hidden">
                                    총상품금액 안내
                                </h4>
                                <a href="#" class="tooltip_hide"
                                    ><i class="btn_close"
                                        ><span class="blind">닫기</span></i
                                    ></a
                                >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Vue from "vue";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

// Import Bootstrap an BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);
export default {};
</script>

<style>
.scale-down {
    object-fit: scale-down;
    width: 100%;
}
.detailTop {
    width: 100%;
    display: flex;
}
.leftBox {
    width: 50%;
    padding: 0 0;
}
.rightBox {
    width: 50%;
    padding: 0 0;
    margin-left: auto;
}
</style>