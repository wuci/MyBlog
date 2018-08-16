<template>
  <div class="hello">
    <el-row style="height: 70%;">
      <el-col :span="24">
        <!-- <img src="@/assets/img/index/top1.jpg" alt="" style="width: 100%;height: 100%;"> -->
        <el-carousel :interval="5000" indicator-position="none" style="height:500px;overflow-y: hidden">
          <el-carousel-item v-for="item in 3" :key="item">
            <img :src="getImage(item)" alt="" style="width: 100%;height: 100%;">
          </el-carousel-item>
        </el-carousel>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24" style="text-align: center;margin-top: 5px;">

        <el-tabs type="border-card" style="width: 30%;margin:-4px auto;border: none;height: 350px;" @tab-click="tabEvent" v-model="activeName">
          <el-tab-pane name="login">
            <span slot="label">
              <div style="width: 112px">
                <i class="el-icon-ts-gohome i-jj"></i>登录</div>
            </span>
            <el-input v-model="username" placeholder="请输入用户名/手机号" class="inputextend jianju" suffix-icon="el-icon-ts-single"></el-input>
            <br>
            <el-input v-model="password" placeholder="请输入密码" class="inputextend jianju" suffix-icon="el-icon-ts-lock" type="password"></el-input>
            <br>

            <el-button type="text" style="font-size: 12px;color:darkgray;float: left;margin-left: 10%;">忘记密码?</el-button>
            <br>
            <br>
            <el-button type="primary" class="inputextend jianju" @click="login">确认登录</el-button>

          </el-tab-pane>
          <el-tab-pane name="register">
            <span slot="label">
              <div style="width: 112px">
                <i class="el-icon-ts-gerenyonghu i-jj"></i>注册</div>
            </span>
            <el-steps :active="active" align-center>
              <el-step title="用户名"></el-step>
              <el-step title="设置密码"></el-step>
              <el-step title="绑定手机"></el-step>
              <el-step title="完成注册"></el-step>
            </el-steps>

            <el-input v-model="usernameR" placeholder="请输入用户名" class="inputextend jianju" suffix-icon="el-icon-ts-single" type="text"
              v-if="active===1"></el-input>

            <el-input v-model="phone" placeholder="请输入手机号" class="inputextend jianju" suffix-icon="el-icon-ts-phone" type="text" v-if="active===3"></el-input>
            <div style="width: 80%;margin: 0 auto;">
              <el-input v-model="yzmVal" placeholder="请输入验证码" class="jianju" type="text" style="float: left;width: 50%;height:50px;" v-if="active===3"></el-input>
              <img src="/client/plate/imagecode.htm" width="40%" class="yzm" id="codeImg" onclick="changeImageCode()" v-if="active===3"
              />
            </div>
            <br>
            <el-button type="primary" class="inputextend jianju" @click="stepNext" v-if="active==1">点击下一步</el-button>
            <div v-if="active==2">
              <el-input v-model="passwordR" placeholder="请输入密码" class="inputextend jianju" suffix-icon="el-icon-ts-lock" type="password"></el-input>
              <el-input v-model="passwordR2" placeholder="请再次输入密码" class="inputextend jianju" suffix-icon="el-icon-ts-lock" type="password"></el-input>

            </div>
            <div style="width: 80%;margin: 0 auto;" v-if="active === 2">
              <el-button type="primary" class="inputextend jianju elBtn" @click="stepPred">点击上一步</el-button>
              <el-button type="primary" class="inputextend jianju elBtn" @click="stepNext">点击下一步</el-button>
            </div>
            <div style="width: 80%;margin: 0 auto;" v-if="active === 3">
              <el-button type="primary" class="inputextend jianju elBtn" @click="stepPred">点击上一步</el-button>
              <el-button type="primary" class="inputextend jianju elBtn" @click="sureReg">确认注册</el-button>
            </div>
            <div style="width: 80%;margin: 0 auto;" v-if="active === 4">
              <el-button type="primary" class="inputextend jianju" @click="toLogin" v-if="active==4">完成注册</el-button>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div style=" font-size: 16px; color: darkgray;position:fixed;bottom: 0;width: 100%;">
          © CopyRight 2018 wmlhome.cn 版权所有 浙江杭州拱墅区湖墅南路-2-1
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        username: '',
        password: '',
        active: 1,
        usernameR: '',
        phone: '',
        yzmVal: '',
        activeName: 'login',
        passwordR: '',
        passwordR2: ''
      }
    },
    methods: {
      getImage(index) {
        var path = '/static/img/index/top' + index + '.jpg';
        return path;
      },
      stepPred() {
        if (this.active < 1) {
          this.active = 1
        } else {
          this.active--
        }
      },
      stepNext() {
        if (this.active > 4) {
          this.active = 4
        } else {
          this.active++
        }
      },
      tabEvent() {
        this.active = 1;
        this.usernameR = '';
        this.phone = '';
        this.yzmVal = ''
      },
      sureReg() {
        this.active = 4
      },
      toLogin() {
        this.tabEvent()
        this.activeName = 'login'
      },
      login() {
        this.$router.push("/blog")
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .inputextend {
    width: 80% !important;
    height: 50px !important;
    
  }

  .jianju {
    margin-top: 15px !important;
  }

  .i-jj {
    margin: 10px 10px 0 -10px;
  }

  .el-input__inner {
    height: 50px !important;
  }

  .el-carousel__container {
    height: 500px !important;
  }

  .yzm {
    float: left;
    height: 50px !important;
    margin: 15px 0 0 15px;
  }

  .elBtn {
    width: 47% !important;
    float: left;
  }

</style>
