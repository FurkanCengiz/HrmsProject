# HRMS Project

HRMS (Human Resources Management System) projesi, insan kaynakları süreçlerini yönetmek ve optimize etmek amacıyla geliştirilmiş bir web uygulamasıdır. Bu proje, iş ilanlarının yayınlanması, başvuru yönetimi ve kullanıcı rolleri gibi temel İK işlevlerini içermektedir.

## İçindekiler

- [Proje Hakkında](#proje-hakkında)
- [Özellikler](#özellikler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Teknolojiler](#teknolojiler)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)

## Proje Hakkında

HRMS Projesi, işverenlerin iş ilanlarını oluşturabileceği ve yönetebileceği, iş arayanların bu ilanlara başvurabileceği bir platform sunar. Proje, modern İK süreçlerine uygun bir altyapı sağlamak için tasarlanmıştır.

### Amaç

- İş ilanlarının etkin bir şekilde yönetimi
- Kullanıcı rollerine dayalı esnek erişim kontrolü
- İş arayanlar ve işverenler için kullanıcı dostu bir deneyim sağlama

## Özellikler

- **Kullanıcı Yönetimi:** İş arayanlar, işverenler ve sistem yöneticileri için farklı roller.
- **İş İlanları:** İşverenler tarafından iş ilanı oluşturma, düzenleme ve yayınlama.
- **Başvuru Yönetimi:** İş arayanların ilanlara başvurması ve başvuruların işverenler tarafından incelenmesi.
- **Doğrulama ve Onay:** E-posta doğrulama ve ilan onaylama süreçleri.
- **API Desteği:** Dış sistemlerle entegrasyon için RESTful API.

## Kurulum

### Gereksinimler

- **Java 17+**
- **Spring Boot**
- **PostgreSQL**
- **Maven**
- **Postman (isteğe bağlı)**

### Adımlar

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/furkancengiz6/HrmsProject.git
   ```
2. Proje dizinine gidin:
   ```bash
   cd HrmsProject
   ```
3. Bağımlılıkları yükleyin:
   ```bash
   mvn install
   ```
4. PostgreSQL veritabanını oluşturun ve `application.properties` dosyasındaki ayarları güncelleyin:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:3306/hrms
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
5. Uygulamayı başlatın:
   ```bash
   mvn spring-boot:run
   ```

## Kullanım

- Uygulama, varsayılan olarak `http://localhost:8080` adresinde çalışır.
- Postman veya tarayıcı aracılığıyla API uç noktalarını test edebilirsiniz.

## Teknolojiler

- **Backend:** Java, Spring Boot
- **Veritabanı:** PostgreSQL, Hibernate
- **API:** RESTful API
- **Proje Yönetimi:** Maven

## Katkıda Bulunma

Katkıda bulunmak isterseniz aşağıdaki adımları takip edebilirsiniz:

1. Bu projeyi forklayın.
2. Yeni bir dal oluşturun:
   ```bash
   git checkout -b feature/yenilik
   ```
3. Değişikliklerinizi yapın ve commit edin:
   ```bash
   git commit -m "Yeni bir özellik eklendi."
   ```
4. Dalınızı uzak depoya push edin:
   ```bash
   git push origin feature/yenilik
   ```
5. Bir Pull Request oluşturun.

## Lisans

Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için [LICENSE](LICENSE) dosyasını inceleyebilirsiniz.

---

Herhangi bir sorunuz veya öneriniz varsa, lütfen iletişime geçmekten çekinmeyin:

- **E-posta:** furkancengiz111@gmail.com
- **GitHub:** [furkancengiz6](https://github.com/furkancengiz6)

![Screenshot 2021-06-30 at 10-43-01 Swagger UI](https://user-images.githubusercontent.com/76488131/123921727-ffcb5b00-d98f-11eb-8fad-770e19182726.png)

