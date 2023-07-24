def encrypt(s: String, key: Int): String = {
    var arr: Array[Char] = new Array[Char](s.length());
    var i = 0;
    for(l <- s){
        // for lowercase
        if (l >= 'a' && l <= 'z'){
            var res: Char = (l + key).toChar;
            if (res > 'z'){
                res = (('a' - 1) + (res - 'z')).toChar;
            }else if(res < 'a'){
                res = (('z' + 1) - ('a' - res)).toChar;
            }
            arr(i) = res;
        // for uppercase
        }else if(l >= 'A' && l <= 'Z'){
            var res: Char = (l + key).toChar;
            if (res > 'Z'){
                res = (('A' - 1) + (res - 'Z')).toChar;
            }else if(res < 'A'){
                res = (('Z' + 1) - ('A' - res)).toChar;
            }
            arr(i) = res;
        // for number, symbol
        }else{
            arr(i) = l;
        }
        i += 1;
    }
    arr.mkString;
}


def decrypt(s: String, key: Int): String = {
    var arr: Array[Char] = new Array[Char](s.length());
    var i = 0;
    for(l <- s){
        // for lowercase
        if (l >= 'a' && l <= 'z'){
            var res: Char = (l - key).toChar;
            if (res > 'z'){
                res = (('a' - 1) + (res - 'z')).toChar;
            }else if(res < 'a'){
                res = (('z' + 1) - ('a' - res)).toChar;
            }
            arr(i) = res;
        // for uppercase
        }else if(l >= 'A' && l <= 'Z'){
            var res: Char = (l - key).toChar;
            if (res > 'Z'){
                res = (('A' - 1) + (res - 'Z')).toChar;
            }else if(res < 'A'){
                res = (('Z' + 1) - ('A' - res)).toChar;
            }
            arr(i) = res;
        }else{
            arr(i) = l;
        }
        i += 1;
    }
    arr.mkString;
}


def caesarCipher(msg: String, key: Int)(encryptionFunc: (String, Int) => String)(decryptionFunc: (String, Int) => String) = {
    println("------------------------");
    println("Original message: " + msg);
    val encrptMessage = encryptionFunc(msg, key);
    println("Encrypted message: " + encrptMessage);
    val decryptMessage = decryptionFunc(encrptMessage, key);
    println("Decrypted message: " + decryptMessage);
}

object Question01 extends App{
    print("Enter the message: ");
    val msg = scala.io.StdIn.readLine();
    print("Enter the key value: ");
    var key = scala.io.StdIn.readInt();
    key = key % 26;
    caesarCipher(msg, key)(encrypt)(decrypt);
}