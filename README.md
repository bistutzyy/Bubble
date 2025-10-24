# 消灭泡泡糖 - Bubble Popstar 🎈

一个基于 JavaFX 开发的经典消除类益智游戏，提供流畅的游戏体验和精美的视觉效果。

![游戏图标](PRJ_BU2_JAVA_001/src/res/img/popstar.png)

## 📖 项目简介

**消灭泡泡糖（Bubble Popstar）** 是一款休闲益智类消除游戏。玩家需要点击相同颜色的相邻泡泡糖进行消除，消除的泡泡糖越多，得分越高。游戏设有多个关卡，每个关卡都有相应的目标分数，达到目标分数即可通关。

### 作者信息
- **开发者**: Frank.Chen
- **版本**: 1.5
- **技术支持**: www.campsg.cn

## 🎮 游戏特色

### 核心玩法
- **点击消除**: 点击2个或以上相同颜色的相邻泡泡糖进行消除
- **重力效果**: 消除后泡泡糖会自动下落和左移填补空位
- **关卡系统**: 多个难度递增的关卡
- **目标分数**: 每关都有特定的目标分数需要达成

### 计分规则

#### 基础消除得分
消除泡泡糖的得分公式：**得分 = 5 × n²**（n为消除的泡泡糖数量）

具体示例：
- 消除 1 个泡泡糖 → 5 分
- 消除 2 个泡泡糖 → 20 分
- 消除 3 个泡泡糖 → 45 分
- 消除 4 个泡泡糖 → 80 分
- 消除 5 个泡泡糖 → 125 分
- 消除 10 个泡泡糖 → 500 分

> 💡 **技巧提示**: 尽量一次性消除更多的泡泡糖，因为得分是按平方增长的！

#### 清空奖励
当场上剩余泡泡糖数量小于等于5个时，会获得额外奖励：

**奖励分数 = 20 × (剩余泡泡糖数 - 5)²**

具体示例：
- 剩余 5 个泡泡糖 → 奖励 0 分
- 剩余 4 个泡泡糖 → 奖励 20 分
- 剩余 3 个泡泡糖 → 奖励 80 分
- 剩余 2 个泡泡糖 → 奖励 180 分
- 剩余 1 个泡泡糖 → 奖励 320 分
- 剩余 0 个泡泡糖 → 奖励 500 分

> 💡 **技巧提示**: 争取清空所有泡泡糖获得最高奖励！

### 游戏道具

游戏提供三种特殊道具辅助玩家：

| 道具 | 图标 | 功能说明 |
|------|------|----------|
| 💣 **炸弹** | ![炸弹](PRJ_BU2_JAVA_001/src/res/img/bomb.png) | 可消除周围的泡泡糖 |
| 🎨 **油漆桶** | ![油漆桶](PRJ_BU2_JAVA_001/src/res/img/paint.png) | 可改变泡泡糖的颜色 |
| 🌈 **彩虹** | ![彩虹](PRJ_BU2_JAVA_001/src/res/img/rainbow.png) | 可消除任意颜色的一列泡泡糖 |

## 🖼️ 游戏界面

### 界面布局
```
┌─────────────────────────────────────┐
│  第1关    目标 1000      💰          │  ← 关卡信息栏
├─────────────────────────────────────┤
│        分数：0     💣 🎨 🌈          │  ← 分数和道具栏
├─────────────────────────────────────┤
│                                     │
│       [游戏区域 10×10]               │  ← 游戏区域（480×480像素）
│                                     │
│         🔴🔵🟢🟡🟣                    │
│         🔵🟢🔴🟡🔵                    │
│                                     │
├─────────────────────────────────────┤
│  技术支持：www.campsg.cn             │  ← 底部信息栏
└─────────────────────────────────────┘
```

### 主要资源文件

#### 图片资源
```
src/res/img/
├── popstar.png      # 游戏图标
├── bomb.png         # 炸弹道具
├── paint.png        # 油漆桶道具
├── rainbow.png      # 彩虹道具
├── bubble2.png      # 泡泡糖图片
├── money_plus.png   # 金币图标
├── front.jpg        # 前景图片
├── front2.png       # 前景图片2
└── csg.png         # 网站图标
```

#### 样式主题
游戏提供两套CSS皮肤主题：
- `skin1.css` - 默认主题
- `skin2.css` - 备选主题

## 🛠️ 技术架构

### 技术栈
- **Java**: JDK 1.8
- **UI框架**: JavaFX
- **依赖注入**: Spring Framework 3.2.0
- **日志**: Log4j 1.2.15
- **构建工具**: Eclipse + JavaFX Plugin

### 项目结构
```
PRJ_BU2_JAVA_001/
├── src/                          # 源代码目录
│   ├── cn/campsg/practical/bubble/
│   │   ├── MainClass.java        # 程序入口
│   │   ├── MainForm.java         # 主窗体（720行核心代码）
│   │   ├── common/               # 公共组件
│   │   │   ├── Message.java      # 消息常量
│   │   │   ├── StarAnimation.java # 动画效果
│   │   │   └── StarFormUtils.java # 泡泡糖UI工具类
│   │   ├── service/              # 业务逻辑层
│   │   │   ├── StarService.java      # 泡泡糖服务接口
│   │   │   ├── StarServiceImpl.java  # 泡泡糖服务实现
│   │   │   ├── ScoreService.java     # 计分服务接口
│   │   │   ├── ScoreServiceImpl.java # 计分服务实现
│   │   │   └── ScoreManager.java     # 分数管理器
│   │   └── util/                 # 工具类
│   │       └── StarsUtil.java    # 泡泡糖工具类
│   ├── res/                      # 资源文件
│   │   ├── layout/
│   │   │   └── main_layout.fxml  # 主界面布局
│   │   ├── img/                  # 图片资源
│   │   └── css/                  # 样式文件
│   ├── service.xml               # Spring配置文件
│   ├── score.conf                # 分数配置文件
│   └── log4j.properties          # 日志配置
├── bin/                          # 编译输出目录
├── lib/                          # 第三方依赖库
│   ├── spring-*.jar              # Spring框架
│   ├── log4j-1.2.15.jar         # 日志组件
│   ├── commons-logging-1.0.4.jar # 日志组件
│   └── entity.jar               # 实体类库
└── build.fxbuild                # JavaFX构建配置
```

### 核心类说明

#### MainForm.java（主窗体类）
- **功能**: 游戏主界面控制器，包含所有游戏逻辑
- **代码行数**: 721 行
- **主要功能**:
  - 初始化游戏界面和泡泡糖矩阵
  - 处理用户点击事件
  - 控制泡泡糖消除和移动动画
  - 关卡管理和分数统计
  - 通关判定和失败重试

#### StarService（泡泡糖服务）
- 创建10×10泡泡糖矩阵
- 查找可消除的泡泡糖集合
- 计算泡泡糖移动路径（垂直和水平）
- 判断游戏结束条件

#### ScoreService（计分服务）
- 根据消除数量计算得分
- 计算清空奖励分数
- 管理关卡目标分数
- 判断是否通关

### 设计模式
- **MVC模式**: 界面、业务逻辑和数据分离
- **依赖注入**: Spring IoC容器管理服务对象
- **观察者模式**: 事件监听机制处理用户交互

## 🚀 运行方法

### 环境要求
- **JDK**: 1.8 或更高版本（必须支持 JavaFX）
- **操作系统**: Windows / macOS / Linux
- **内存**: 至少 512MB RAM

### 方法一：使用已编译的class文件（推荐）

项目已经编译完成，可以直接运行：

```bash
# 1. 进入项目目录
cd PRJ_BU2_JAVA_001

# 2. 运行游戏（Windows）
java -cp "bin;lib/*" cn.campsg.practical.bubble.MainClass

# 3. 运行游戏（macOS/Linux）
java -cp "bin:lib/*" cn.campsg.practical.bubble.MainClass
```

### 方法二：使用IDE运行

#### Eclipse
1. 导入项目：`File` → `Import` → `Existing Projects into Workspace`
2. 选择 `PRJ_BU2_JAVA_001` 目录
3. 右键点击 `MainClass.java` → `Run As` → `Java Application`

#### IntelliJ IDEA
1. 打开项目：`File` → `Open` → 选择 `PRJ_BU2_JAVA_001` 目录
2. 添加依赖库：`File` → `Project Structure` → `Libraries` → 添加 `lib` 目录下的所有jar文件
3. 运行 `MainClass` 的 `main` 方法

### 方法三：重新编译后运行

如果需要修改代码后重新编译：

```bash
# 1. 编译源代码
cd PRJ_BU2_JAVA_001/src
javac -d ../bin -cp "../lib/*" cn/campsg/practical/bubble/*.java cn/campsg/practical/bubble/*/*.java

# 2. 复制资源文件（如果修改了资源）
# Windows
xcopy res ..\bin\res /E /I /Y
# Linux/macOS
cp -r res ../bin/

# 3. 运行游戏
cd ..
java -cp "bin;lib/*" cn.campsg.practical.bubble.MainClass
```

## 🎯 游戏玩法技巧

### 新手入门
1. **观察全局**: 游戏开始时先观察整个棋盘，寻找连接数量最多的泡泡糖团
2. **从大到小**: 优先消除大的泡泡糖团，因为得分按平方计算
3. **规划路线**: 考虑消除后泡泡糖会如何移动，提前规划下一步

### 进阶技巧
1. **连锁反应**: 利用泡泡糖下落和左移的特性，创造连锁消除
2. **保留选项**: 不要过早消除小团，可能会阻断更大的消除机会
3. **追求清空**: 尽量清空所有泡泡糖获得最高奖励（500分）
4. **颜色平衡**: 注意保持各种颜色泡泡糖的平衡，避免某种颜色过于零散

### 高分策略
- 单次消除10个以上泡泡糖可获得500+分
- 清空棋盘额外获得500分
- 第一关目标1000分，后续关卡目标递增
- 每通过一定数量的关卡，难度会提升

## 📦 依赖库说明

### Spring Framework 3.2.0
- `spring-beans-3.2.0.RC1.jar` - Bean容器
- `spring-context-3.2.0.RC1.jar` - 应用上下文
- `spring-context-support-3.2.0.RC1.jar` - 上下文支持
- `spring-core-3.2.0.RC1.jar` - 核心库
- `spring-expression-3.2.0.RC1.jar` - 表达式语言

### 日志组件
- `log4j-1.2.15.jar` - Log4j日志框架
- `commons-logging-1.0.4.jar` - Apache通用日志接口

### 实体类库
- `entity.jar` - 游戏实体类（Star、StarList、MovedStar等）

## 🐛 调试模式

项目支持调试模式，可以显示泡泡糖坐标等信息：

1. 修改 `log4j.properties` 文件，设置日志级别为 `DEBUG`：
```properties
log4j.rootLogger=DEBUG, stdout
```

2. 重新运行游戏，点击顶部标题栏可以显示/隐藏泡泡糖坐标

## 📝 配置文件说明

### service.xml
Spring配置文件，定义了两个核心服务Bean：
- `scoreService` - 计分服务
- `starService` - 泡泡糖服务

### score.conf
分数配置文件，可以自定义：
- 初始目标分数
- 关卡递增规则
- 奖励分数计算参数

### log4j.properties
日志配置文件，控制日志输出级别和格式

## 🔧 常见问题

### Q1: 运行时提示找不到JavaFX类
**A**: 确保使用的是Oracle JDK 8，OpenJDK某些版本不包含JavaFX。或者需要单独安装JavaFX SDK。

### Q2: 中文显示乱码
**A**: 源代码使用GBK编码，如果IDE显示乱码，请设置编码为GBK或GB2312。

### Q3: 无法加载资源文件
**A**: 确保资源文件在正确的位置（bin/res目录），如果重新编译需要复制资源文件到bin目录。

### Q4: Spring初始化失败
**A**: 检查lib目录下的jar包是否完整，确保service.xml在classpath中。

## 🎨 自定义主题

游戏支持自定义CSS主题，可以修改以下文件：
- `src/res/css/skin1.css`
- `src/res/css/skin2.css`

在 `main_layout.fxml` 中可以切换主题：
```xml
stylesheets="@../css/skin2.css"
```

## 📄 许可证

本项目为学习和教学目的创建，欢迎学习和参考。

## 🔗 相关链接

- **技术支持**: www.campsg.cn
- **Java官方文档**: https://docs.oracle.com/javase/8/docs/
- **JavaFX文档**: https://docs.oracle.com/javase/8/javafx/api/
- **Spring Framework**: https://spring.io/projects/spring-framework

## 💬 联系方式

如有问题或建议，请访问：www.campsg.cn

---

**享受游戏，挑战高分！** 🎮✨

