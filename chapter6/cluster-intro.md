# 集群

集群是一组可以互相通信的服务器，集群大小可 **动态变化**，并且可以在发生错误时继续运行，集群一般具备 2 个功能：

* 失败检测
* 为所有节点提供一致性视图

## 失败检测

集群大小是动态变化的：

1. 节点宕机 or 网络故障，集群变小
2. 添加节点，集群变大

节点之间通过发送消息 and 获得相应来确定其他节点的可用性，为提升效率，Akka 的失败检测仅会检测某节点附近的少量节点，Akka Cluster 中，每个结点监控的 **最大节点数** 默认为 5 个。

Akka 的失败检测是通过节点间发送 **心跳消息** 实现的，Akka 根据心跳的历史记录 + 当前心跳信息计算某节点的可用性，并根据计算结果，将节点标记为 **可用** or **不可用**。

## 用 gossip 协议实现最终一致性

节点 A 与其相邻节点交换信息，其邻居又和自己的邻居交换信息，直到节点 A 的信息送达集群中 **所有节点**，集群中每个结点都会经历节点 A 的过程，最终集群对各结点状态达成一致。

这种算法为 gossip 协议，很多最终一致性的数据库都使用了该协议（例如 Riak Cassandra Dynamo 等）。
