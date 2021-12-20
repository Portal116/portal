<template>
  <div class="container">
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
                <p class="price">9900원</p>
                <p class="deliveryFee">배송비 무료</p>
              </div>
            </div>
          </div>
          <div class="item_option_area">
            <div class="form_body">
              <div>
                <h3>옵션 선택</h3>
                <b-dropdown id="dropdown-1" text="옵션 1" class="m-md-2">
                  <b-dropdown-item>멘트기모후드티</b-dropdown-item>
                  <b-dropdown-item>룩스기모팬츠</b-dropdown-item>
                  <b-dropdown-item>파먼기모팬츠</b-dropdown-item>
                </b-dropdown>
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
              <p class="total" id="coreTotalPriceP" style="visibility: hidden">
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
                  >0<span class="unit">11000원</span></strong
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
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="clear"></div>
    <div class="shop-info">
      <div class="shop-infoBox">
        <div class="shop-title">메이킹 유</div>
      </div>
      <div class="shop-bestItem">
        <h4 class="bestItemMore">
          이 판매자의 인기상품이에요
          <button>더 보기</button>
        </h4>
        <div>
          <ul>
            <li>
              <img
                class="bestPic"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
              />
            </li>
            <li>
              <img
                class="bestPic"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
              />
            </li>
            <li>
              <img
                class="bestPic"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
              />
            </li>
            <li>
              <img
                class="bestPic"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
              />
            </li>
            <li>
              <img
                class="bestPic"
                src="http://gdimg.gmarket.co.kr/1513973750/still/600?ver=1639527436"
              />
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="clear"></div>
    <div class="detail">
      <b-card no-body>
        <b-tabs card>
          <b-tab no-body title="Picture 1">
            <div class="box__detail-view js-toggle-content">
              <div class="vip-detailarea_seller">
                <iframe
                  id="detail1"
                  src="http://item.gmarket.co.kr/Item/ItemDetail?goodsCode=1513973750&detailVersionType=2&isNew=false"
                  onload="detailIframeLoaded('detail1');"
                  frameborder="0"
                  width="860"
                  scrolling="NO"
                ></iframe>
              </div>
            </div>
            <b-card-footer>Picture 1 footer</b-card-footer>
          </b-tab>

          <b-tab no-body title="Picture 2">
            <b-card-img
              bottom
              src="https://picsum.photos/600/200/?image=25"
              alt="Image 25"
            ></b-card-img>
            <b-card-footer>Picture 2 footer</b-card-footer>
          </b-tab>

          <b-tab no-body title="Picture 3">
            <b-card-img
              bottom
              src="https://picsum.photos/600/200/?image=26"
              alt="Image 26"
            ></b-card-img>
            <b-card-footer>Picture 3 footer</b-card-footer>
          </b-tab>

          <b-tab title="Text">
            <b-card-title
              >This tab does not have the <code>no-body</code> prop
              set</b-card-title
            >
            <b-card-text>
              Quis magna Lorem anim amet ipsum do mollit sit cillum voluptate ex
              nulla tempor. Laborum consequat non elit enim exercitation cillum
              aliqua consequat id aliqua. Esse ex consectetur mollit voluptate
              est in duis laboris ad sit ipsum anim Lorem. Incididunt veniam
              velit elit elit veniam Lorem aliqua quis ullamco deserunt sit enim
              elit aliqua esse irure.
            </b-card-text>
          </b-tab>
        </b-tabs>
      </b-card>
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

<style scoped>
html {
  overflow-y: scroll;
}
* {
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
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

.shop-info {
  width: 100%;
  height: 200px;
  border: 1px black solid;
  overflow: hidden;
}
.shop-infoBox {
  float: left;
  position: relative;
  width: 20%;
  height: 100%;
  border: 1px black solid;
}
.shop-title {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 150%;
}
.shop-bestItem {
  float: right;
  width: 80%;
  height: 198px;
  padding: 0px 0px;
  border: 1px black solid;
}
.bestItemMore {
  border: 1px black solid;
  padding: 5px 10px;
}
.bestPic {
  height: 135px;
  padding: 0px 22px 10px 23px;
}
li {
  float: left;
}

.clear {
  clear: both;
}
</style>