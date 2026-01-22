# FoodExpress API II

## Descripción General

**FoodExpress API II** es un sistema backend desarrollado con Spring Boot que gestiona una plataforma de pedidos de comida en línea. Facilita la interacción entre restaurantes, clientes y órdenes, proporcionando funcionalidades completas para la administración de pedidos, gestión de platos y reportes de negocio.

## Funcionalidades Principales

### Autenticación y Seguridad
El sistema implementa un mecanismo robusto de autenticación que permite a los usuarios registrarse e iniciar sesión de forma segura. Utiliza roles de usuario para controlar los accesos y permisos dentro de la plataforma, diferenciando entre clientes, administradores y otros perfiles según sea necesario.

### Gestión de Restaurantes
Los restaurantes pueden registrarse en la plataforma y ser consultados por los clientes. El sistema mantiene un catálogo centralizado de establecimientos, permitiendo la búsqueda y visualización de información relevante como nombre, ubicación y detalles de contacto.

### Catálogo de Platos
Cada restaurante gestiona su propio catálogo de platos disponibles. Los platos se organizan por categoría (pizzas, hamburguesas, postres) y contienen información como descripción, precio y disponibilidad. Los clientes pueden consultar este catálogo antes de hacer un pedido.

### Sistema de Pedidos
Los clientes pueden crear pedidos seleccionando platos de diferentes restaurantes. Cada pedido incluye múltiples detalles que especifican qué platos se han solicitado, en qué cantidad y a qué precio. El sistema mantiene un control completo del ciclo de vida de los pedidos.

### Estados de Pedidos
Los pedidos transitan por diferentes estados a lo largo de su procesamiento: pendiente, confirmado, en preparación, listo para recoger, entregado o cancelado. Esto permite un seguimiento transparente del progreso de cada pedido.

### Reportes y Análisis
La plataforma genera reportes detallados sobre la actividad de negocio, incluyendo estadísticas de platos más solicitados por restaurante, recuentos de órdenes y análisis de tendencias de venta. Estos datos son esenciales para la toma de decisiones empresariales.

## Arquitectura Técnica

El proyecto sigue una arquitectura de capas bien definida:

- **Controladores**: Manejan las solicitudes HTTP y definen los endpoints de la API REST
- **Servicios**: Contienen la lógica de negocio y la orquestación de operaciones
- **Repositorios**: Gestionan el acceso a datos mediante JPA/Hibernate
- **Entidades**: Representan los modelos de datos principales
- **DTOs**: Objetos de transferencia de datos para las comunicaciones API-Cliente
- **Manejo de Excepciones**: Manejador global centralizado que proporciona respuestas de error consistentes

## Modelos de Datos Principales

El sistema se estructura alrededor de varias entidades clave:

- **Usuario**: Representa a las personas que usan la plataforma con credenciales y roles asignados
- **Restaurante**: Comercios que ofrecen sus servicios a través de la plataforma
- **Plato**: Productos individuales ofertados por los restaurantes
- **Pedido**: Solicitud de compra realizada por un cliente con estado y fecha
- **DetalleDelPedido**: Información específica de cada plato incluido en un pedido

## Responsabilidades Principales

Esta API maneja aspectos críticos del negocio como la validación de datos de entrada, el cálculo de totales de órdenes, la asignación de estados apropiados, la autenticación segura de usuarios y la generación de reportes para análisis de negocio. El sistema es extensible y puede adaptarse fácilmente a nuevos requisitos.

---

**Estado**: En desarrollo activo | **Versión**: 0.0.1-SNAPSHOT
