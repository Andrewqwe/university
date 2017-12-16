var ArrayList = Java.type('java.util.ArrayList');
function trimAndSplit(text){
    return text.replace(/ +/g, " ").split(" ");
}