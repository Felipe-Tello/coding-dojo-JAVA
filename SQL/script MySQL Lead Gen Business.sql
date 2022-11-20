-- 1. ¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?

select sum(billing.amount) as monto, monthname(billing.charged_datetime) as mes, year(billing.charged_datetime) as año
from billing
where monthname(billing.charged_datetime) like "%march%" and year(billing.charged_datetime) = 2012
group by monthname(billing.charged_datetime);

-- 2. ¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del cliente con una identificación de 2?

select sum(billing.amount) as monto, clients.client_id
from billing
join clients on clients.client_id = billing.client_id
where clients.client_id=2
group by clients.client_id=2;

-- 3. ¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?

select sites.domain_name, clients.client_id
from sites
left join clients on clients.client_id = sites.client_id
where clients.client_id = 10;

-- 4. ¿Qué consulta ejecutaría para obtener el número total de sitios creados por mes por año para el cliente con una identificación de 1? ¿Qué pasa con el cliente = 20?

select count(sites.domain_name) as numeros_de_sitios, monthname(sites.created_datetime) as mes , year(sites.created_datetime) as año, clients.client_id, sites.domain_name
from sites
join clients on clients.client_id = sites.client_id
where clients.client_id=1 or clients.client_id= 20
group by sites.domain_name
order by clients.client_id asc;

-- 5. ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales generados para cada uno de los sitios entre el 1 de enero de 2011 y el 15 de febrero de 2011?

select sites.domain_name, count(leads.leads_id), date(leads.registered_datetime)
from sites
join leads on leads.site_id = sites.site_id
where date(leads.registered_datetime) between '2011/01/01' and '2011/02/15'
group by leads.leads_id;

-- 6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de leads que hemos generado para cada uno de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?

select concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, count(leads.leads_id)
from clients
join sites on sites.client_id = clients.client_id
join leads on leads.site_id = sites.site_id
where date(leads.registered_datetime) between '2011/01/01' and '2011/12/31'
group by nombre_de_cliente;

-- 7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de leads que hemos generado para cada cliente cada mes entre los meses 1 y 6 del año 2011?

select concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, count(leads.leads_id) as leads, monthname(leads.registered_datetime) as mes
from clients
join sites on sites.client_id = clients.client_id
join leads on leads.site_id = sites.site_id
where leads.registered_datetime between '2011/01/01' and '2011/06/30'
group by nombre_de_cliente , mes;

-- 8. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de leads que hemos generado para cada uno de los sitios de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011? Solicite esta consulta por ID de cliente. Presente una segunda consulta que muestre todos los clientes, los nombres del sitio y el número total de leads generados en cada sitio en todo momento.

select clients.client_id, concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, sites.domain_name, count(leads.leads_id)
from clients
join sites on clients.client_id = sites.client_id
join leads on leads.site_id = sites.site_id
where leads.registered_datetime between "2011/01/01" and "2011/12/31"
group by sites.domain_name;

select clients.client_id, concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, sites.domain_name, count(leads.leads_id)
from clients
left join sites on clients.client_id = sites.client_id
left join leads on leads.site_id = sites.site_id
group by sites.domain_name, clients.client_id;

-- 9. Escriba una sola consulta que recupere los ingresos totales recaudados de cada cliente para cada mes del año. Pídalo por ID de cliente.

select clients.client_id, concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, monthname(billing.charged_datetime) as mes_de_cobro, year(billing.charged_datetime) as anio_de_cobro, sum(billing.amount)
from clients
left join billing on clients.client_id = billing.client_id
group by nombre_de_cliente, mes_de_cobro, anio_de_cobro;

-- 10. Escriba una sola consulta que recupere todos los sitios que posee cada cliente. Agrupe los resultados para que cada fila muestre un nuevo cliente. Se volverá más claro cuando agregue un nuevo campo llamado 'sitios' que tiene todos los sitios que posee el cliente. (SUGERENCIA: use GROUP_CONCAT)

select clients.client_id, concat_ws(" ",clients.first_name, clients.last_name) as nombre_de_cliente, group_concat(sites.domain_name separator "/")
from clients
left join sites on clients.client_id = sites.client_id
group by nombre_de_cliente







