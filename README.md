# Brkat Tunnel - Android VPN Application

## نظرة عامة
تطبيق Brkat Tunnel هو تطبيق VPN احترافي لـ Android يدعم عدة بروتوكولات وطرق نقل متقدمة.

## المميزات

### البروتوكولات المدعومة
- VMess
- VLESS
- Trojan
- Shadowsocks
- SOCKS5
- HTTP Proxy
- SSH Tunnel

### طرق النقل
- TCP
- WebSocket
- HTTP
- HTTP Upgrade
- gRPC
- QUIC
- TLS
- Reality
- XTLS

### الميزات الرئيسية

#### 1. إدارة السيرفرات
- إضافة وتعديل وحذف السيرفرات
- نسخ وتصدير واستيراد الملفات
- تنظيم السيرفرات في مجموعات
- تمييز السيرفرات المفضلة

#### 2. الإحصائيات
- عرض سرعة التحميل والرفع
- إجمالي البيانات المنقولة
- مدة الاتصال
- معلومات IP والدول
- Ping و Packet Loss

#### 3. الأدوات
- Ping Tool
- DNS Lookup
- IP Information
- Port Checker
- MTU Test
- Network Information

#### 4. السجلات
- تتبع أحداث الاتصال
- عرض الأخطاء والتحذيرات
- البحث في السجلات
- حذف السجلات القديمة تلقائياً

#### 5. الإعدادات
- اتصال تلقائي
- إعادة اتصال تلقائية
- Keep Alive
- Wake Lock
- الوضع الداكن والفاتح
- إشعارات مخصصة

## البنية المعمارية

```
app/src/main/java/com/brkat/tunnel/
├── BrkatApplication.java          # التطبيق الرئيسي
├── models/                         # نماذج البيانات
│   ├── Server.java
│   ├── ConnectionStats.java
│   └── ConnectionLog.java
├── database/                       # طبقة قاعدة البيانات
│   ├── BrkatDatabase.java
│   ├── ServerDao.java
│   ├── ConnectionStatsDao.java
│   └── ConnectionLogDao.java
├── repository/                     # طبقة البيانات
│   ├── ServerRepository.java
│   ├── ConnectionStatsRepository.java
│   └── ConnectionLogRepository.java
├── ui/                            # واجهات المستخدم
│   ├── activities/
│   │   ├── MainActivity.java
│   │   ├── ServerDetailsActivity.java
│   │   ├── SettingsActivity.java
│   │   └── AboutActivity.java
│   ├── fragments/
│   │   ├── HomeFragment.java
│   │   ├── ServersFragment.java
│   │   ├── LogsFragment.java
│   │   ├── ToolsFragment.java
│   │   └── SettingsFragment.java
│   └── adapters/
│       ├── MainPagerAdapter.java
│       ├── ServersAdapter.java
│       └── LogsAdapter.java
├── service/                       # الخدمات
│   ├── VpnService.java
│   └── BackgroundService.java
├── receivers/                     # المستقبلات
│   ├── BootReceiver.java
│   └── NetworkReceiver.java
├── utils/                         # الأدوات المساعدة
│   ├── PreferenceManager.java
│   ├── LogUtils.java
│   ├── EncryptionUtils.java
│   ├── ValidationUtils.java
│   ├── FormatUtils.java
│   └── FileUtils.java
└── viewmodel/                     # نماذج العرض
    ├── ServerViewModel.java
    └── ConnectionLogViewModel.java
```

## المتطلبات

- Android SDK 26+
- Android Studio 4.0+
- Gradle 7.0+
- Java 11+

## المكتبات المستخدمة

- AndroidX
- Material Design 3
- Room Database
- LiveData
- ViewModel
- DataStore
- OkHttp
- Gson

## التثبيت والبناء

```bash
# استنساخ المستودع
git clone https://github.com/brkatt/brkat-tunnel.git

# فتح المشروع في Android Studio
cd brkat-tunnel

# بناء المشروع
./gradlew build

# تشغيل التطبيق
./gradlew installDebug
```

## الإصدار

الإصدار الحالي: 1.0.0

## الترخيص

هذا المشروع مرخص تحت GNU General Public License v3.0

## المطورون

فريق تطوير Brkat Tunnel

## الدعم والتطوير

للبلاغ عن الأخطاء أو طلب ميزات جديدة، يرجى فتح Issue على GitHub.
