/*
 * MIT License
 *
 * Copyright (c) 2023-2024 4ra1n (Jar Analyzer Team)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.n1ar4.jar.analyzer.entity;

import me.n1ar4.jar.analyzer.starter.Const;

public class LuceneSearchResult {
    // 反编译后的代码的文件内容
    public static final int TYPE_CONTENT = 0xf0;
    // 类名：也可以理解成文件名 是一个东西
    public static final int TYPE_CLASS_NAME = 0xf1;

    private int type;
    private String absPathStr;
    private String fileName;
    private String contentStr;
    private String title;
    private int order;
    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAbsPathStr() {
        return absPathStr;
    }

    public void setAbsPathStr(String absPathStr) {
        this.absPathStr = absPathStr;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentStr() {
        return contentStr;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
    }

    public String getClassName() {
        String finalClassPath = this.getAbsPathStr();
        String suffix = finalClassPath.split(Const.tempDir)[1];
        int i = suffix.indexOf("classes");
        if (suffix.contains("BOOT-INF") || suffix.contains("WEB-INF")) {
            suffix = suffix.substring(i + 8, suffix.length() - 6);
        } else {
            suffix = suffix.substring(1, suffix.length() - 6);
        }
        String className = suffix.replace("\\", "/");
        className = className.replace("/", ".");
        className = className.replace(".class", "");
        return className;
    }

    @Override
    public String toString() {
        return "LuceneSearchResult{" +
                "type=" + type +
                ", absPathStr='" + absPathStr + '\'' +
                ", fileName='" + fileName + '\'' +
                ", contentStr='" + contentStr + '\'' +
                '}';
    }
}
