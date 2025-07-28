public class Teste {

    public SimpleFeature bufferFeature(SimpleFeature feature,
            Measure<Double, Length> distance) {
        // extract the geometry
        GeometryAttribute gProp = feature.getDefaultGeometryProperty();
        CoordinateReferenceSystem origCRS = gProp.getDescriptor()
                .getCoordinateReferenceSystem();

        Geometry geom = (Geometry) feature.getDefaultGeometry();
        Geometry pGeom = geom;
        MathTransform toTransform;
        MathTransform fromTransform = null;
        // reproject the geometry to a local projection
        if (!(origCRS instanceof ProjectedCRS)) {

            Point c = geom.getCentroid();
            double x = c.getCoordinate().x;
            double y = c.getCoordinate().y;

            String code = "AUTO:42001," + x + "," + y;
            CoordinateReferenceSystem auto;
            try {
                auto = CRS.decode(code);
                toTransform = CRS.findMathTransform(
                        DefaultGeographicCRS.WGS84, auto);
                fromTransform = CRS.findMathTransform(auto,
                        DefaultGeographicCRS.WGS84);
                pGeom = JTS.transform(geom, toTransform);
            } catch (MismatchedDimensionException | TransformException
                    | FactoryException e) {
                e.printStackTrace();
            }

        }

        // buffer
        Geometry out = buffer(pGeom, distance.doubleValue(SI.METER));
        Geometry retGeom = out;
        // reproject the geometry to the original projection
        if (!(origCRS instanceof ProjectedCRS)) {
            try {
                retGeom = JTS.transform(out, fromTransform);
            } catch (MismatchedDimensionException | TransformException e) {
                e.printStackTrace();
            }
        }
        // return a new feature containing the geom
        SimpleFeatureType schema = feature.getFeatureType();
        SimpleFeatureTypeBuilder ftBuilder = new SimpleFeatureTypeBuilder();
        ftBuilder.setCRS(origCRS);
        ftBuilder.addAll(schema.getAttributeDescriptors());
        ftBuilder.setName(schema.getName());

        SimpleFeatureType nSchema = ftBuilder.buildFeatureType();
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(nSchema);
        List<Object> atts = feature.getAttributes();
        for (int i = 0; i < atts.size(); i++) {
            if (atts.get(i) instanceof Geometry) {
                atts.set(i, retGeom);
            }
        }
        return builder.buildFeature(null, atts.toArray());
    }
}
