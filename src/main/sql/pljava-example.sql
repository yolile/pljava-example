-- load java library
-- parameters:
--   url_path - where the library is located
--   url_name - how the library is referred to later
--   deploy   - should the deployment descriptor be used
--

select sqlj.install_jar('file:///tmp/pljava-example.jar', 'encrypt', true);
-- set classpath to include new library.
--
-- parameters
--   schema    - schema (or database) name
--   classpath - colon-separated list of url_names.
--
select sqlj.set_classpath('public', 'encrypt');

-- create function
--
CREATE FUNCTION public.encrypt(varchar, varchar) RETURNS varchar
  AS 'main.java.EncryptExample.getStringMessageDigest'
  LANGUAGE java;

select encrypt('id','MD5');