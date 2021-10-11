package com.android.oda.data.shopping

class ProductsApiMock {

    companion object {

        fun getMockJsonForUrl(url: String): String {
            return when {
                url.endsWith(ProductsApiUrls.shoppingInfo) -> shoppingListResponse
                else -> ""
            }
        }

        private val shoppingListResponse = """
            {
              "items": [
                {
                  "product": {
                    "id": 23551,
                    "full_name": "Gresskar Butternut Portugal/ Spania, 750 g",
                    "brand": null,
                    "brand_id": null,
                    "name": "Gresskar Butternut",
                    "name_extra": "Portugal/ Spania, 750 g",
                    "front_url": "https://oda.com/no/products/23551-gresskar-butternut-guatamala-brasil/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/d0083d5f-1101-4e7c-82e8-9f4210fdbd65.jpg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=9eb7e438355082640c659b688d507b18"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/d0083d5f-1101-4e7c-82e8-9f4210fdbd65.jpg?fit=max&w=1000&s=29e819edce758f77b2e646cc79e406db"
                        }
                      }
                    ],
                    "gross_price": "33.00",
                    "gross_unit_price": "44.00",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "33.00",
                  "discounted_display_price_total": "33.00",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 15163,
                    "full_name": "Koriander Gourmet Frisk i Pose, Etiopia, 20 g",
                    "brand": null,
                    "brand_id": null,
                    "name": "Koriander Gourmet",
                    "name_extra": "Frisk i Pose, Etiopia, 20 g",
                    "front_url": "https://oda.com/no/products/15163-fersk-koriander-i-pose-etiopia-spania/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/304941bc-5b84-4b4f-9aa3-903fff81d7a9.jpg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=54cac47fcc6e13bf6724035b55218136"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/304941bc-5b84-4b4f-9aa3-903fff81d7a9.jpg?fit=max&w=696&s=03359dccc7315d748fd6657478f15f6b"
                        }
                      }
                    ],
                    "gross_price": "27.60",
                    "gross_unit_price": "1380.00",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "27.60",
                  "discounted_display_price_total": "27.60",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 27243,
                    "full_name": "FreshFlowers Tulipaner Mix 15 stk",
                    "brand": "FreshFlowers",
                    "brand_id": 1339,
                    "name": "Tulipaner Mix",
                    "name_extra": "15 stk",
                    "front_url": "https://oda.com/no/products/27243-freshflowers-miks-tulipaner/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/0343e38d-0a8c-45bd-b038-f13101ff8994.jpeg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=cb96b4e8088d032561f35dfc9f714b76"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/4b80d143-e7ee-4e06-98ab-4ffc59f9f6b5.jpeg?fit=max&w=1000&s=e45093dc2cbc6900c6a93b698e1dbf85"
                        }
                      }
                    ],
                    "gross_price": "129.00",
                    "gross_unit_price": "8.60",
                    "unit_price_quantity_abbreviation": "stk",
                    "unit_price_quantity_name": "Stykk",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "129.00",
                  "discounted_display_price_total": "129.00",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 11917,
                    "full_name": "Brødverket Gourmet Grovbrød Oppskåret, 670 g",
                    "brand": "Brødverket",
                    "brand_id": 1341,
                    "name": "Gourmet Grovbrød",
                    "name_extra": "Oppskåret, 670 g",
                    "front_url": "https://oda.com/no/products/11917-brodverket-steinovnsbakt-brod-oppskaret/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/ec7a4336-b425-4753-9673-aabf6e2cdb32.jpg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=ef53d5d3a95860c4690d555ca0983010"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/ec7a4336-b425-4753-9673-aabf6e2cdb32.jpg?fit=max&w=1000&s=7febc46384297c5ec1e0c8312f91f44a"
                        }
                      }
                    ],
                    "gross_price": "33.57",
                    "gross_unit_price": "50.10",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": {
                      "is_discounted": true,
                      "undiscounted_gross_price": "37.30",
                      "undiscounted_gross_unit_price": "55.67",
                      "description_short": "-10%"
                    },
                    "promotion": {
                      "title": "Salg!",
                      "title_color": "413746",
                      "background_color": "FFC000",
                      "text_color": "F19500",
                      "description_short": "Salg! -10%",
                      "accessibility_text": "Salg: -10%"
                    },
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": [
                      {
                        "name": "Nøkkelhullsmerket",
                        "image_url": "https://kolonial.no/static/products/img/nokkelhullet60x60.7fc5e3450b59.png",
                        "is_important": false
                      }
                    ]
                  },
                  "quantity": 0,
                  "display_price_total": "37.30",
                  "discounted_display_price_total": "33.57",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 29984,
                    "full_name": "Ricotta Ambrosi, 250 g",
                    "brand": null,
                    "brand_id": null,
                    "name": "Ricotta",
                    "name_extra": "Ambrosi, 250 g",
                    "front_url": "https://oda.com/no/products/29984-ricotta-ambrosi/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/a529fcfc-785c-4740-a0a0-bc71470aac81.jpeg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=d0dcb4e5789b901819c5b4ba212f1b16"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/a529fcfc-785c-4740-a0a0-bc71470aac81.jpeg?fit=max&w=1000&s=c45a6fb3c7bf5c4114bc74587d9fb18c"
                        }
                      }
                    ],
                    "gross_price": "24.90",
                    "gross_unit_price": "99.60",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": false,
                      "code": "sold_out_supplier",
                      "description": "Utsolgt fra leverandør",
                      "description_short": "Utsolgt"
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "24.90",
                  "discounted_display_price_total": "24.90",
                  "availability": {
                    "is_available": false,
                    "code": "sold_out_supplier",
                    "description": "Utsolgt fra leverandør",
                    "description_short": "Utsolgt"
                  }
                },
                {
                  "product": {
                    "id": 18223,
                    "full_name": "REMA 1000 Fullkornsris Boil-in-bag 8x125g, 1 kg",
                    "brand": "REMA 1000",
                    "brand_id": 550,
                    "name": "Fullkornsris",
                    "name_extra": "Boil-in-bag 8x125g, 1 kg",
                    "front_url": "https://oda.com/no/products/18223-rema-1000-fullkornsris-boil-in-bag-8x125g/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/fa9f565b-c217-4581-b893-7f3bc94ce60d.png?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=7eb95bb64307286c307656c7953f32e7"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/fa9f565b-c217-4581-b893-7f3bc94ce60d.png?fit=max&w=612&s=9089203e8c68678bcb8c1dafe3928ae8"
                        }
                      }
                    ],
                    "gross_price": "35.60",
                    "gross_unit_price": "35.60",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "35.60",
                  "discounted_display_price_total": "35.60",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 18925,
                    "full_name": "Patak's Mild Curry Paste 165 g",
                    "brand": "Patak's",
                    "brand_id": 229,
                    "name": "Mild Curry Paste",
                    "name_extra": "165 g",
                    "front_url": "https://oda.com/no/products/18925-pataks-mild-curry-paste/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/31997c1d-0dbb-432b-af90-a7b408aa566e.jpeg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=18dcd1496e96b5803b9ff0acbc9cd526"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/65baeb8c-ade7-45ef-9c3c-3742a14516a2.jpg?fit=max&w=412&s=bf29871aa7beac195b39af46c64c6356"
                        }
                      }
                    ],
                    "gross_price": "33.70",
                    "gross_unit_price": "204.24",
                    "unit_price_quantity_abbreviation": "kg",
                    "unit_price_quantity_name": "Kilogram",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "33.70",
                  "discounted_display_price_total": "33.70",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                },
                {
                  "product": {
                    "id": 29606,
                    "full_name": "Kokosmelk Vår beste pris, 400 ml",
                    "brand": null,
                    "brand_id": null,
                    "name": "Kokosmelk",
                    "name_extra": "Vår beste pris, 400 ml",
                    "front_url": "https://oda.com/no/products/29606-kokosmelk/",
                    "images": [
                      {
                        "thumbnail": {
                          "url": "https://bilder.kolonial.no/produkter/9db27582-59f5-428a-b114-71176bbb3dd3.jpeg?fill=solid&fill-color=ffffff&fit=fill&h=280&w=280&s=7c5b628b0ec0829071b43881cfbfe11c"
                        },
                        "large": {
                          "url": "https://bilder.kolonial.no/produkter/9db27582-59f5-428a-b114-71176bbb3dd3.jpeg?fit=max&w=1000&s=20f6bd053093b175a8f158e3e5225b48"
                        }
                      }
                    ],
                    "gross_price": "13.90",
                    "gross_unit_price": "34.75",
                    "unit_price_quantity_abbreviation": "l",
                    "unit_price_quantity_name": "Liter",
                    "discount": null,
                    "promotion": null,
                    "availability": {
                      "is_available": true,
                      "code": "available",
                      "description": "",
                      "description_short": ""
                    },
                    "client_classifiers": []
                  },
                  "quantity": 0,
                  "display_price_total": "13.90",
                  "discounted_display_price_total": "13.90",
                  "availability": {
                    "is_available": true,
                    "code": "available",
                    "description": "",
                    "description_short": ""
                  }
                }
              ],
              "extra_lines": [
                {
                  "description": "Varerabatt",
                  "long_description": null,
                  "gross_amount": "-3.73"
                },
                {
                  "description": "2 poser",
                  "long_description": null,
                  "gross_amount": "3.20"
                }
              ]
            }
        """.trimIndent()
    }
}