-- joining tables
-- join
-- Find all the clients ( first and last name billing amounts and charged date )
select clients.first_name, clients.last_name, billing.amount, billing.charged_datetime
from clients
join billing on clients.id = billing.clients_id;
-- list all the domain names and leads (first and last name) for each site
select sites.domain_name, leads.first_name, leads.last_name
from sites
join leads on sites.id= leads.sites_id;
-- join on multiples tables
-- get the names of the clients, their domain sites and the first names fo all the leads generated from the sites
select clients.first_name as nombres_clientes, clients.last_name, sites.domain_name, leads.first_name as nombres_lideres
from clients
join sites on clients.id = sites.clients_id
join leads on sites.id = leads.sites_id;
-- left and right join
-- List all the clients and the sites each client has, even the client hasn't landed a site yet
select clients.first_name, clients.last_name, sites.domain_name
from clients
left join sites on clients.id = sites.clients_id;
-- grouping rows
-- groups by
-- sum, min, max, avg
-- Find all the clients (first an last name) and their total billing amounts
select clients.first_name, clients.last_name, sum(billing.amount)
from clients
join billing on clients.id = billing.clients_id
group by clients.id;
-- group concat
-- List all the domains names associated with each client
select group_concat(' ',sites.domain_name) as doomains, clients.first_name, clients.last_name
from clients
join sites on clients.id = sites.clients_id
group by clients.id;
-- count
-- find the total number of leads for each site
select leads.id, sites.domain_name
from sites
join leads on sites.id = leads.sites_id
group by sites.id;



