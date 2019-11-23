# youran代码自动化平台

## 介绍

这是一款包含系统设计和代码生成功能的自动化web平台，使用本平台可以极大提升程序员的开发效率

**包含如下特色功能：**
1. ★★★基于git增量生成代码[点击查看原理](/doc/IncrementalGeneration.md)：支持将代码直接生成到远程git仓库，同时支持在元数据变动以后再次生成（只生成差异部分）。
2. ★★★自定义模板：如果预置的代码模板不能满足您的需求，可基于您自己团队的技术框架开发属于您独有的代码模板。
3. ★反向工程：如果您的应用已经完成了表结构设计，请使用'反向工程'功能将建表语句反向导入项目中，自动生成实体和字段。
4. 多对多关系：支持在两个实体之间的建立多对多关联关系，会在mysql中生成一张关联表，可以设置两个实体之间是否持有对方引用，持有引用的一方会自动生成维护关联关系的rest服务。
5. 外键关联：在添加字段的时候，可以设置该字段是否外键，外键字段需要关联某个实体的主键，从而可以实现‘一对一’或‘一对多’关联。
6. 级联扩展：外键字段或多对多实体上可以配置级联字段，级联字段可以作为被关联实体的查询条件，也能作为查询结果展示。
7. 实体ER图：可以在实体列表页选择多个存在关联关系的实体，点击'查看ER图'按钮，即可生成实体关系图。
8. 代码预览：不需要下载就可以在线浏览生成的代码。

> 代码增量生成功能是本系统最大亮点，现在各个公司的软件都流行敏捷迭代开发，
> 一旦使用了此功能，您在整个软件迭代周期中都能用本系统生成新的功能模块。
> 这也是“代码生成工具”和“`代码自动化平台`”的最大差别

## 安装部署

#### 第一步、环境准备
1. 系统依赖：mysql数据库、jdk8、maven
2. 在mysql中提前建好表，建表语句参考：[youran-generate-web/src/test/resources/DB/generate.sql](./youran-generate-web/src/test/resources/DB/generate.sql)
3. 根据本地环境修改配置文件：[youran-generate-web/src/main/resources/application-local.yml](./youran-generate-web/src/main/resources/application-local.yml)

#### 第二步、编译打包及运行
``` bash
# 安装前端项目npm依赖
cd youran-generate-ui
npm install

# 开发模式启动前端环境
# npm run dev

# 将前端资源编译到后端项目中
# 编译目标路径：youran-generate-web/src/main/resources/ui
npm run build

# 后端代码编译打包
cd ../
mvn clean package

# 运行spring-boot项目
java -jar youran-generate-web/target/youran-generate-web-3.0.0-SNAPSHOT.war

```

#### 第三步、首次访问系统时，需要导入系统预置代码模板

系统预置模板包括：

- 标准java后端模板： [源码地址](https://gitee.com/caixiaoge/youran-template-01) [zip压缩包](https://gitee.com/caixiaoge/youran-template-01/releases)
- 标准vue前端模板： [源码地址](https://gitee.com/caixiaoge/youran-template-02) [zip压缩包](https://gitee.com/caixiaoge/youran-template-02/releases)

后续还会推出其他技术栈的模板，我也希望您给本项目贡献新的代码模板


## 使用说明

一、最佳方案`推荐`（在本工程中进行模型设计，代码同步到git）
0. 在gitlab或github之类的代码平台上创建空的工程
1. 本系统中创建项目并录入git地址
2. 创建实体
3. 创建实体字段
4. 创建枚举及枚举字段【可选】
5. 创建多对多关联关系【可选】
6. 创建字段索引【可选】
7. 执行“提交Git”


二、传统方案`不推荐`（设计完表结构后执行反向工程）
0. 提前设计好表结构
1. 创建项目
2. 执行反向工程将建表语句导入项目中
3. 调整字段的属性（因为反向工程导入的字段信息量太少，部分属性设置了默认值）
4. 创建枚举及枚举字段【可选】
5. 创建多对多关联关系【可选】
7. 生成代码

## 术语解析
1. 项目：项目就是一个独立的应用系统，可以基于一个项目生成一整套JavaWeb后端服务系统。
2. 实体：一个实体对应数据库里一张业务表，同时对应后端一整套增删改查服务，同时实体之间也可以有‘一对多’，‘多对多’等关联关系。
3. 字段：这里的字段既是数据库业务表中的字段，也是java实体类中的字段，一个字段有非常多的属性可以配置。
4. 枚举：建议将不常变化的一类常量数据创建成枚举，会在java代码中生成对应的enum类。
5. 索引：就是mysql业务表中的索引。
