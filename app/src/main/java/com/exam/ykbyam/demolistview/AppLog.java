package com.exam.ykbyam.demolistview;

import android.content.Context;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 開発用ログ出力クラス.
 * <p>
 * Created by y-kuboyama on 2016/06/13.
 */
public class AppLog {

    /**
     * Log Output Flag
     */
    private static boolean sIsDebuggable = BuildConfig.DEBUG;

    /**
     * Log Tag String
     */
    private static final String TAG = AppLog.class.getSimpleName();

    /**
     * Default get StackTrace Level
     */
    private static final int STACK_TRACE_LEVEL = 7;

    /**
     * Output Log Operation Enum
     *
     * @author y-kuboyama
     */
    private enum Operation {

        /**
         * Log Level on Verbose.
         */
        Verbose {
            void output(String tag, String msg, int level) {
                if (TextUtils.isEmpty(tag)) {
                    tag = TAG;
                }
                if (msg == null) {
                    android.util.Log.v(tag, getStackTrace(level));
                } else {
                    android.util.Log.v(tag, getStackTrace(level) + msg);
                }
            }
        },

        /**
         * Log Level on Error.
         */
        Error {
            void output(String tag, String msg, int level) {
                if (tag == null) {
                    tag = TAG;
                }
                if (msg == null) {
                    android.util.Log.e(tag, getStackTrace(level));
                } else {
                    android.util.Log.e(tag, getStackTrace(level) + msg);
                }
            }
        },

        /**
         * Log Level on Warn.
         */
        Warn {
            void output(String tag, String msg, int level) {
                if (tag == null) {
                    tag = TAG;
                }
                if (msg == null) {
                    android.util.Log.w(tag, getStackTrace(level));
                } else {
                    android.util.Log.w(tag, getStackTrace(level) + msg);
                }
            }
        },

        /**
         * Log Level on Info.
         */
        Info {
            void output(String tag, String msg, int level) {
                if (tag == null) {
                    tag = TAG;
                }
                if (msg == null) {
                    android.util.Log.i(tag, getStackTrace(level));
                } else {
                    android.util.Log.i(tag, getStackTrace(level) + msg);
                }
            }
        },

        /**
         * Log Level on Debug.
         */
        Debug {
            void output(String tag, String msg, int level) {
                if (tag == null) {
                    tag = TAG;
                }
                if (msg == null) {
                    android.util.Log.d(tag, getStackTrace(level));
                } else {
                    android.util.Log.d(tag, getStackTrace(level) + msg);
                }
            }
        };

        // Log output method.
        abstract void output(String tag, String msg, int level);
    }


    //  Error Level Section  ///////////////////////////////////////////////////////////////////////


    /**
     * ログレベル:Errorでログを出力する.
     * <p>
     * 識別用タグにこのクラスの名前を付与する.
     */
    public static void e() {
        eImpl(null, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Errorでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.
     *
     * @param tag 識別用タグ文字列
     */
    public static void e(String tag) {
        eImpl(tag, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Errorでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.
     *
     * @param tag 識別用タグ文字列
     * @param msg メッセージ文字列
     */
    public static void e(String tag, String msg) {
        eImpl(tag, msg, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Errorでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    public static void e(String tag, String msg, int level) {
        eImpl(tag, msg, level);
    }

    /*
     * ログレベル:Errorでログを出力する処理の実装.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    private static void eImpl(String tag, String msg, int level) {
        if (sIsDebuggable) Operation.Error.output(tag, msg, level);
    }


    //  Warning Level Section  /////////////////////////////////////////////////////////////////////


    /**
     * ログレベル:Warnでログを出力する.
     * <p>
     * 識別用タグにこのクラスの名前を付与する.
     */
    public static void w() {
        wImpl(null, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Warnでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.
     *
     * @param tag 識別用タグ文字列
     */
    public static void w(String tag) {
        wImpl(tag, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Warnでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.
     *
     * @param tag 識別用タグ文字列
     * @param msg メッセージ文字列
     */
    public static void w(String tag, String msg) {
        wImpl(tag, msg, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Warnでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    public static void w(String tag, String msg, int level) {
        wImpl(tag, msg, level);
    }

    /*
     * ログレベル:Warnでログを出力する処理の実装.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    private static void wImpl(String tag, String msg, int level) {
        if (sIsDebuggable) Operation.Warn.output(tag, msg, level);
    }


    //  Information Level Section  /////////////////////////////////////////////////////////////////


    /**
     * ログレベル:Infoでログを出力する.
     * <p>
     * 識別用タグにこのクラスの名前を付与する.
     */
    public static void i() {
        iImpl(null, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Infoでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.
     *
     * @param tag 識別用タグ文字列
     */
    public static void i(String tag) {
        iImpl(tag, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Infoでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.
     *
     * @param tag 識別用タグ文字列
     * @param msg メッセージ文字列
     */
    public static void i(String tag, String msg) {
        iImpl(tag, msg, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Infoでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    public static void i(String tag, String msg, int level) {
        iImpl(tag, msg, level);
    }

    /*
     * ログレベル:Infoでログを出力する処理の実装.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    private static void iImpl(String tag, String msg, int level) {
        if (sIsDebuggable) Operation.Info.output(tag, msg, level);
    }


    //  Debug Level Section  ///////////////////////////////////////////////////////////////////////


    /**
     * ログレベル:Debugでログを出力する.
     * <p>
     * タグに固定文字列"LogUtil"を付与する.
     */
    public static void d() {
        dImpl(null, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Debugでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.
     *
     * @param tag 識別用タグ文字列
     */
    public static void d(String tag) {
        dImpl(tag, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Debugでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.
     *
     * @param tag 識別用タグ文字列
     * @param msg メッセージ文字列
     */
    public static void d(String tag, String msg) {
        dImpl(tag, msg, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Debugでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    public static void d(String tag, String msg, int level) {
        dImpl(tag, msg, level);
    }

    /*
     * ログレベル:Debugでログを出力する処理の実装.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    private static void dImpl(String tag, String msg, int level) {
        if (sIsDebuggable) {
            Operation.Debug.output(tag, msg, level);
        }
    }


    //  Verbose Level Section  /////////////////////////////////////////////////////////////////////


    /**
     * ログレベル:Verboseでログを出力する.
     * <p>
     * タグに固定文字列"LogUtil"を付与する.
     */
    public static void v() {
        vImpl(null, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Verboseでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.
     *
     * @param tag 識別用タグ文字列
     */
    public static void v(String tag) {
        vImpl(tag, null, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Verboseでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.
     *
     * @param tag 識別用タグ文字列
     * @param msg メッセージ文字列
     */
    public static void v(String tag, String msg) {
        vImpl(tag, msg, STACK_TRACE_LEVEL);
    }

    /**
     * ログレベル:Verboseでログを出力する.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    public static void v(String tag, String msg, int level) {
        vImpl(tag, msg, level);
    }

    /*
     * ログレベル:Verboseでログを出力する処理の実装.
     * <p>
     * 識別用タグに引数に指定した文字列を使用する.<br/>
     * 出力メッセージに引数に渡された任意の文字列を追加する.<br/>
     * 取得するスタックトレース階層は引数で指定する.
     *
     * @param tag   識別用タグ文字列
     * @param msg   メッセージ文字列
     * @param level 取得対象のStackTraceレベル
     */
    private static void vImpl(String tag, String msg, int level) {
        if (sIsDebuggable) {
            Operation.Verbose.output(tag, msg, level);
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    /*-- Other Methods Section  --*/
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ログ出力:呼び出し元メソッドの情報と呼び出されたメソッドの情報.
     *
     * @param tag 任意のタグ文字列
     * @param msg 任意のメッセージ文字列
     */
    public static void invoke(String tag, String msg) {
        if (sIsDebuggable) {
            // 呼び出し元のスタックトレース取得
            String invokeMsg = "Invoked From " + getStackTrace(5);
            // 呼び出された部分のスタックトレース取得
            String calledMsg = " Called Is " + msg + ":" + getStackTrace(4);
            android.util.Log.i(tag, invokeMsg + calledMsg);
        }
    }

    /**
     * スタックトレースからクラス名、メソッド名、ライン番号を取得する.
     *
     * @param level 取得レベル
     * @return [クラス名::メソッド名:ライン番号]
     */
    private static String getStackTrace(int level) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[level];
        String className = element.getClassName().substring(element.getClassName().lastIndexOf(".") + 1);
        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();
        return "[" + className + "::" + methodName + ":" + lineNumber + "]";
    }

    /**
     * InputStreamをログファイルとして出力する.
     * <p>
     * アプリケーション領域のfilesフォルダに引数で指定したファイル名で出力する.
     *
     * @param fileName    ファイル名
     * @param context     ApplicationContext
     * @param inputStream InputStream
     * @throws IOException
     */
    public static void dumpStream(String fileName, Context context, InputStream inputStream) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int len = inputStream.read(buffer);
            if (len < 0) {
                break;
            }
            bout.write(buffer, 0, len);
        }
        FileOutputStream os = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        os.write(bout.toByteArray());
    }


}
