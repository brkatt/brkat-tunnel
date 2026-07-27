package com.brkat.tunnel.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Server - نموذج بيانات السيرفر
 * يحتوي على جميع معلومات السيرفر المطلوبة للاتصال
 */
@Entity(tableName = "servers")
public class Server implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    // معلومات أساسية
    public String name;
    public String protocol; // VMess, VLESS, Trojan, Shadowsocks, SOCKS5, HTTP, SSH
    public String address;
    public int port;

    // بيانات المصادقة
    public String uuid;
    public String password;
    public String username;

    // معلومات النقل
    public String transport; // TCP, WebSocket, HTTP, HTTP/2, gRPC, QUIC
    public String transportPath;
    public String transportHost;
    public String transportHeaders;

    // تشفير وأمان
    public boolean tlsEnabled;
    public String tlsVersion;
    public String sni;
    public String alpn;
    public String fingerprint;
    public boolean realityEnabled;
    public String realityPublicKey;
    public String realityShortId;

    // إعدادات إضافية
    public String dns;
    public int mtu;
    public boolean udpEnabled;
    public String notes;

    // ملفات التعريف
    public long createdAt;
    public long updatedAt;
    public boolean isFavorite;
    public int fileVersion;
    public String groupName;
    public int sortOrder;

    // إحصائيات الاتصال
    public long bytesReceived;
    public long bytesSent;
    public long connectionDuration;
    public String lastConnectedIp;
    public String lastConnectedCountry;
    public double lastConnectedPing;

    public Server() {
        this.tlsEnabled = false;
        this.realityEnabled = false;
        this.udpEnabled = true;
        this.isFavorite = false;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.fileVersion = 1;
        this.sortOrder = 0;
        this.bytesReceived = 0;
        this.bytesSent = 0;
        this.connectionDuration = 0;
    }

    public String getServerIdentifier() {
        return protocol + "://" + address + ":" + port;
    }

    public boolean isValid() {
        return name != null && !name.isEmpty() &&
                protocol != null && !protocol.isEmpty() &&
                address != null && !address.isEmpty() &&
                port > 0 && port < 65536;
    }

    public Server copy() {
        Server server = new Server();
        server.name = this.name + " (نسخة)";
        server.protocol = this.protocol;
        server.address = this.address;
        server.port = this.port;
        server.uuid = this.uuid;
        server.password = this.password;
        server.username = this.username;
        server.transport = this.transport;
        server.transportPath = this.transportPath;
        server.transportHost = this.transportHost;
        server.transportHeaders = this.transportHeaders;
        server.tlsEnabled = this.tlsEnabled;
        server.tlsVersion = this.tlsVersion;
        server.sni = this.sni;
        server.alpn = this.alpn;
        server.fingerprint = this.fingerprint;
        server.realityEnabled = this.realityEnabled;
        server.realityPublicKey = this.realityPublicKey;
        server.realityShortId = this.realityShortId;
        server.dns = this.dns;
        server.mtu = this.mtu;
        server.udpEnabled = this.udpEnabled;
        server.notes = this.notes;
        server.isFavorite = false;
        server.groupName = this.groupName;
        return server;
    }
}