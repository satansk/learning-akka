# 多核 -> 并行编程

摩尔定律预测每 18 个月，单位面积上晶体管数量增加一倍。

今天，摩尔定律早已失效，单个 CPU 上集成越来越多的核已是趋势，因此即使应用运行在 *单台机器* 上，也应该考虑使用 **并行编程**，因为 **单线程** 程序只能利用一个核，写的再完美也无法有效利用硬件。

并行编程！

>并行 vs 并发
>
>* 并行：同时处理多个任务
>* 并发：能处理多个任务，不一定同时
>
>因此，单核不存在并行，却存在并发（时间片）。

## `Future` vs `Actor`

传统的 **线程模型** 基于同步和锁，多线程 **共享可变状态** 非常容易造成 race condition，难以编写正确的并行代码。

Akka 提供了更加容易掌握的编程模型，用于 **并行编程**：

* `Future`
* `Actor`

两者都可用于并发编程，简单选择方式为：

* 需要 **管理状态**，则用 `Actor`
* 只要并发，**没有状态**，则用 `Future`

这种选择方式有点简单粗暴，具体问题还需具体分析。

## 示例

为展示如何用 `Future` 或 `Actor` 进行并行编程，考虑将如下函数并行化：

```Scala
object ArticleParser {
  def apply(html: String): String = ArticleExtractor.INSTANCE.getText(html)
}
```