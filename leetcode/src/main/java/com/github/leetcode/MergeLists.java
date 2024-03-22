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

    public static List<String> mergeLists(Node head, List<String>... lists) {

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
                preIndex = i - 1;
                nextIndex = i + 1;
                String ch = sublist.get(i);

                boolean nonRepetitive = true;

                // 计算包含重复项的mapList数量
                List<Map<String, Node>> containsMapList = new ArrayList<>();
                for (Map<String, Node> map : mapList) {
                    if (map.containsKey(ch)) {
                        containsMapList.add(map);
                    }
                }

                // 检查当前元素是否已经存在于链表中
                int checkedCount = 0;
                for (Map<String, Node> map : mapList) {
                    // 遍历每个重复子map中是否存在重复项，当前map中根据上下文没有匹配上重复项，就继续匹配下一个map，直到匹配上为止
                    Map<String, Node> targetMap = map;
                    boolean contains = targetMap.containsKey(ch);
                    if (contains) {
                        if (preIndex >= 0) {

                            if (nextIndex < sublist.size()) {
                                // 需要比pre next
                                Node mapItem = targetMap.get(ch);
                                boolean duplicate = false;
                                try {
                                    duplicate = checkPreNextDumplicate(preIndex, nextIndex, sublist, mapItem);
                                } catch (Exception e) {
                                }

                                if (duplicate) {
                                    // 再次匹配目标的前前元素，后后元素

                                    // 匹配前前
                                    try {
                                        duplicate = checkPreDumplicate(preIndex - 1, sublist, mapItem.prev);
                                    } catch (Exception e) {
                                    }

                                    if (duplicate) {
                                        // 匹配后后
                                        try {
                                            duplicate = checkNextDumplicate(nextIndex + 1, sublist, mapItem.next);
                                        } catch (Exception e) {
                                        }
                                    }
                                }

                                nonRepetitive = !duplicate;

                            } else {
                                // 需要比pre
                                Node mapItem = targetMap.get(ch);
                                boolean duplicate = false;
                                try {
                                    duplicate = checkPreDumplicate(preIndex, sublist, mapItem);
                                } catch (Exception e) {
                                }
                                if (duplicate) {
                                    // 再次匹配目标的前前元素
                                    try {
                                        duplicate = checkPreDumplicate(preIndex - 1, sublist, mapItem.prev);
                                    } catch (Exception e) {
                                    }
                                }

                                nonRepetitive = !duplicate;
                            }
                        } else {
                            // 只要比next
                            Node mapItem = targetMap.get(ch);
                            boolean duplicate = false;
                            try {
                                duplicate = checkNextDumplicate(nextIndex, sublist, mapItem);
                            } catch (Exception e) {
                            }
                            if (duplicate) {
                                // 再次匹配目标的后后元素
                                try {
                                    duplicate = checkNextDumplicate(nextIndex + 1, sublist, mapItem.next);
                                } catch (Exception e) {
                                }
                            }
                            nonRepetitive = !duplicate;
                        }


                    } else {
                        nonRepetitive = true;
                    }

                    if (nonRepetitive == false) {
                        // 根据上下文对比匹配到了重复项，跳出mapList重复项检索逻辑
                        break;
                    }
                }


                if (nonRepetitive) {
                    // 如果不重复，创建新节点并添加到链表尾部
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

    private static boolean checkPreDumplicate(int preIndex, List<String> sublist, Node mapItem) throws RuntimeException {
        if (mapItem == null) {
            return true;
        }
        boolean duplicate = false;
        if (preIndex >= 0 && preIndex < sublist.size()) {
            String preItem = sublist.get(preIndex);
            if (mapItem.prev != null) {
                duplicate = preItem.equals(mapItem.prev.value);
            } else {
                throw new RuntimeException("此结果不需要参考，没有进行比较");
            }
        } else {
            throw new RuntimeException("此结果不需要参考，没有进行比较");
        }

        return duplicate;
    }

    private static boolean checkNextDumplicate(int nextIndex, List<String> sublist, Node mapItem) throws RuntimeException {
        if (mapItem == null) {
            return true;
        }
        boolean duplicate = false;
        if (nextIndex >= 0 && nextIndex < sublist.size()) {
            String nextItem = sublist.get(nextIndex);

            if (mapItem.next != null) {
                duplicate = nextItem.equals(mapItem.next.value);
            } else {
                throw new RuntimeException("此结果不需要参考，没有进行比较");
            }
        } else {
            throw new RuntimeException("此结果不需要参考，没有进行比较");
        }
        return duplicate;
    }

    private static boolean checkPreNextDumplicate(int preIndex, int nextIndex, List<String> sublist, Node mapItem) throws RuntimeException {
        if (mapItem == null) {
            return true;
        }
        boolean duplicate = false;
        String preItem = sublist.get(preIndex);

        /*String nextItem = sublist.get(nextIndex);
        // 需要比pre next
        if (mapItem.prev != null && mapItem.next != null) {
            if (preItem.equals(mapItem.prev.value) &&
                    nextItem.equals(mapItem.next.value)) {
                duplicate = true;
            }
        } else if (mapItem.prev != null) {
            if (preItem.equals(mapItem.prev.value)) {
                duplicate = true;
            }
        } else if (mapItem.next != null) {
            if (nextItem.equals(mapItem.next.value)) {
                duplicate = true;
            }
        } else {
            // pre没比上，next也没比上，一般subList只包含一个元素，且在map中有重复项
            // 这种情况暂时，归类为重复，因为没有上下文，不好界定是否真的是重复元素，先这么处理
            duplicate = true;
        }*/

        if (preIndex >= 0) {
            if (nextIndex < sublist.size()) {
                String nextItem = sublist.get(nextIndex);
                // 需要比pre next
                if (mapItem.prev != null && mapItem.next != null) {
                    duplicate = preItem.equals(mapItem.prev.value) &&
                            nextItem.equals(mapItem.next.value);
                } else if (mapItem.prev != null) {
                    duplicate = preItem.equals(mapItem.prev.value);
                } else if (mapItem.next != null) {
                    duplicate = nextItem.equals(mapItem.next.value);
                } else {
                    throw new RuntimeException("此结果不需要参考，没有进行比较");
                }
            } else {
                // 需要比pre
                if (mapItem.prev != null) {
                    duplicate = preItem.equals(mapItem.prev.value);
                } else {
                    throw new RuntimeException("此结果不需要参考，没有进行比较");
                }
            }
        } else {
            // 只比next
            if (nextIndex < sublist.size()) {
                String nextItem = sublist.get(nextIndex);
                if (mapItem.next != null) {
                    duplicate = nextItem.equals(mapItem.next.value);
                } else {
                    throw new RuntimeException("此结果不需要参考，没有进行比较");
                }
            } else {
                throw new RuntimeException("此结果不需要参考，没有进行比较");
            }

        }

        return duplicate;
    }

    public static void main(String[] args) {
        List<String> originalList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "H", "I", "J", "J", "K", "L", "L", "L", "M", "M", "M", "M", "N", "O", "P", "P", "P", "P", "P", "Q", "R", "S");

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
        List<String> sublist11 = Arrays.asList("M", "N", "O", "P");
        List<String> sublist12 = Arrays.asList("P", "P", "P", "P");
        List<String> sublist13 = Arrays.asList("P", "Q", "R", "S");
        List<String> sublist14 = Arrays.asList("H", "I", "J", "J", "K", "L");
        long startTime = System.currentTimeMillis();

        // 创建双向链表的头节点
        Node head = new Node("\0");
        List<String> mergedList = mergeLists(head, sublist1, sublist2, sublist3, sublist4, sublist5, sublist6, sublist7, sublist8, sublist9, sublist10, sublist11, sublist12, sublist13, sublist14);

        System.out.println("Merged List: " + mergedList);
        System.out.println("耗时: " + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
