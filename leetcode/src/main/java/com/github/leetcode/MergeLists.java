import java.util.*;

public class MergeLists {
    static class Node {
        String value;
        Node prev;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    // 允许连续重复元素出现的次数，也是重复检测map池的数量
    public static final int dumplicateItemCheckPoolSize = 20;

    public static List<String> mergeLists(List<String>... lists) {
        // 创建双向链表的头节点
        Node head = new Node("\0");
        Node tail = head;

        // 创建映射以跟踪每个元素的前一个和后一个元素
        List<Map<String, Node>> mapList = new ArrayList<>();
        for (int i = 0; i < dumplicateItemCheckPoolSize; i++) {
            mapList.add(new HashMap<String, Node>());
        }

        // 遍历所有列表，将元素逐个添加到双向链表中
        for (List<String> sublist : lists) {
            int preIndex = -1;
            int nextIndex = -1;
            for (int i = 0; i < sublist.size(); i++) {
                nextIndex = i + 1;
                String ch = sublist.get(i);

                boolean allow = true;

                // 检查当前元素是否已经存在于链表中
                for (Map<String, Node> map : mapList) {
                    // 遍历每个重复子map中是否存在重复项，当前map中根据上下文没有匹配上重复项，就继续匹配下一个map，直到匹配上为止
                    Map<String, Node> targetMap = map;
                    boolean contains = targetMap.containsKey(ch);
                    if (contains) {
                        if (preIndex >= 0) {
                            String preItem = sublist.get(preIndex);

                            if (nextIndex < sublist.size()) {
                                // 需要比pre next
                                String nextItem = sublist.get(nextIndex);
                                Node mapItem = targetMap.get(ch);
                                if (mapItem.prev != null && mapItem.next != null) {
                                    if (preItem.equals(mapItem.prev.value) &&
                                            nextItem.equals(mapItem.next.value)) {
                                        allow = false;
                                    }
                                } else if (mapItem.prev != null) {
                                    if (preItem.equals(mapItem.prev.value)) {
                                        allow = false;
                                    }
                                } else if (mapItem.next != null) {
                                    if (nextItem.equals(mapItem.next.value)) {
                                        allow = false;
                                    }
                                } else {
                                    // pre没比上，next也没比上，一般subList只包含一个元素，且在map中有重复项
                                    // 这种情况暂时，归类为重复，因为没有上下文，不好界定是否真的是重复元素，先这么处理
                                    allow = false;
                                }

                            } else {
                                // 需要比pre
                                Node mapItem = targetMap.get(ch);
                                if (mapItem.prev != null) {
                                    if (preItem.equals(mapItem.prev.value)) {
                                        allow = false;
                                    }
                                } else {
                                    allow = true;
                                }

                            }
                        } else {
                            // 只要比next
                            if (nextIndex < sublist.size()) {
                                String nextItem = sublist.get(nextIndex);
                                Node mapItem = targetMap.get(ch);
                                if (mapItem.next != null) {
                                    if (nextItem.equals(mapItem.next.value)) {
                                        allow = false;
                                    }
                                } else {
                                    allow = true;
                                }

                            } else {
                                // pre没比上，next也没比上，一般subList只包含一个元素，且在map中有重复项
                                // 这种情况暂时，归类为重复，因为没有上下文，不好界定是否真的是重复元素，先这么处理
                                allow = false;
                            }
                        }


                    } else {
                        allow = true;
                    }

                    if (allow == false) {
                        // 根据上下文对比匹配到了重复项，跳出mapList重复项检索逻辑
                        break;
                    }
                }


                if (allow) {
                    // 如果不存在，创建新节点并添加到链表尾部
                    Node newNode = new Node(ch);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                    for (Map<String, Node> map : mapList) {
                        if (!map.containsKey(ch)) {
                            map.put(ch, newNode);
                            break;
                        }
                    }

                }
                preIndex = i;
            }
        }

        // 构建合并后的列表
        List<String> mergedList = new ArrayList<>();
        Node current = head.next;
        while (current != null) {
            mergedList.add(current.value);
            current = current.next;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<String> originalList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "H", "I", "J", "J", "K", "L", "L", "L", "M", "M", "M", "M");

        List<String> sublist1 = Arrays.asList("A", "B", "C", "D", "E");
        List<String> sublist2 = Arrays.asList("B", "C", "D", "E", "F");
        List<String> sublist3 = Arrays.asList("D", "E", "F", "G", "H");
        List<String> sublist4 = Arrays.asList("D", "E", "F", "G", "H");
        List<String> sublist5 = Arrays.asList("H", "I", "J", "J", "K");
        List<String> sublist6 = Arrays.asList("J", "J", "K", "L");
        List<String> sublist7 = Arrays.asList("K", "L");
//        List<String> sublist7 = Collections.singletonList("K");
        List<String> sublist8 = Arrays.asList("K", "L", "L");
        List<String> sublist9 = Arrays.asList("L", "L", "M", "M");
        List<String> sublist10 = Arrays.asList("M", "M", "M");
        List<String> mergedList = mergeLists(sublist1, sublist2, sublist3, sublist4, sublist5, sublist6, sublist7, sublist8, sublist9, sublist10);

        System.out.println("Merged List: " + mergedList);
    }
}
