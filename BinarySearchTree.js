class Node {
  constructor(value) {
    this.value = value;
  }
}
//places the leaf into the BST
function placeNode(leaf, value) {
  var node = leaf,
      key;
  while (node.value !== value) {
       key = value < node.value ? 'left' : 'right';
       if (!node[key]) {
           node[key] = new Node(value);
           break;
       }
       node = node[key];
  }
  return leaf;
}
//removes the Node from the binary tree
function removeNode(leaf, value){
  if (leaf === null) {
    // Empty tree return false;
 }
 if (key < leaf.data) {
    leaf.left = deleteNode(leaf.left, value);
    return root;
 } else if (value > root.data) {
    leaf.right = deleteNode(leaf.right, value);
    return root;
 } else {

    if (leaf.left === null && leaf.right === null) {
       leaf = null; 
       return leaf;
    }
    // deletes a single node
    if (leaf.left === null) return leaf.right;
    if (leaf.right === null) return leaf.left;

    //deletes two children
    let nowNode = root.right;
    while (nowNode.left !== null) {
       nowNode = currNode.left;
    }
    leaf.data = nowNode.data;
    // Removes right subtree
    leaf.right = deleteNode(leaf.right, nowNode.data);
    return root;
  }
}

var array = [8, 10, 12, 5, 3, 6, 20, 4, 22, 30, 1, 9, 30, 44, 21, 45, 17, 14, 11, 7],
leaf = array.reduce((s, l) => s ? placeNode(s, l) : new Node(l), null);

console.log(leaf);
