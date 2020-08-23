package com.relationalai.infra.config;

import com.amazonaws.regions.Regions;
import com.jsoniter.annotation.JsonProperty;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.relationalai.infra.UnrecognizedRegionException;

public class InfraMetadataConfig
{
    public final static String ATTRIBUTE_NAME = "common-infra-config";
    public final static RaiRegion DEFAULT_REGION = RaiRegion.US_EAST;

    @JsonProperty(from = {"version"}, required=true)
    public String VERSION;

    public static enum Infra
    {
        AWS, AZURE, GCP;
    }

    public static enum RaiRegion
    {
        US_EAST("us-east")
        {
            @Override
            public Regions getAwsRegion()
            {
                return Regions.US_EAST_1;
            }

            @Override
            public Region getAzureRegion()
            {
                return Region.US_EAST;
            }
        };

        String friendlyName;

        private RaiRegion(String name)
        {
            this.friendlyName = name;
        }

        public static RaiRegion fromName(String name) throws UnrecognizedRegionException
        {
            if ( name.equals(US_EAST.friendlyName))
            {
                return US_EAST;
            }

            throw new UnrecognizedRegionException(name);
        }

        public String getName()
        {
            return this.friendlyName;
        }

        public abstract Regions getAwsRegion();
        public abstract Region getAzureRegion();

    }

}
