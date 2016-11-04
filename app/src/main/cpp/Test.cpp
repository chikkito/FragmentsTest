//
// Created by Oscar on 27/10/2016.
//

#include <iostream>
#include <jni.h>
#include <sstream>
using namespace std;

extern "C" JNIEXPORT jstring  JNICALL Java_com_oscar_jfiles_MainActivity_hola(JNIEnv* env, jobject obj){

    char *fin2 ;
    fin2 = (char *) "hola";
    jstring final = env -> NewStringUTF( fin2);

    return final;
}
extern "C" JNIEXPORT jstring Java_com_oscar_jfiles_MainActivity_pib (JNIEnv* env, jobject obj, jfloat pib, jint años, jfloat crecimiento, jint añoi){

	jfloat aux=pib;
	string fin ;
    char *fin2 ;
    stringstream ss;
    for(jint i=0; i<años;i++) {
		aux += (aux * (crecimiento / 100));
		//cout << "año "<< (añoi + i) << " tiene: " << aux << endl;
        ss << "año "<< (añoi + i) << " tiene: " << aux << endl;

	}
    fin += ss.str();
    // applying '->' operator to JNIEnv instead of a pointer
    fin2 = (char *) fin.c_str();
    jstring final = env -> NewStringUTF( fin2);
	return final;
}

extern "C" JNIEXPORT void Java_com_oscar_jfiles_MainActivity_pib__
        (JNIEnv* env, jobject obj,jfloat pib, jint años, jfloat crecimiento, jint añoi,jstring final){

    jfloat aux=pib;
    string fin ;
    char *fin2 ;
    stringstream ss;
    for(jint i=0; i<años;i++) {
        aux += (aux * (crecimiento / 100));
        cout << "año "<< (añoi + i) << " tiene: " << aux << endl;
        ss << "año "<< (añoi + i) << " tiene: " << aux << endl;
        fin += ss.str();
    }

    // applying '->' operator to JNIEnv instead of a pointer
    fin2 = (char *) fin.c_str();
    final = env -> NewStringUTF( fin2);

}