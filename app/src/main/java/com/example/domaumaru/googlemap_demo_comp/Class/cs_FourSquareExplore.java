package com.example.domaumaru.googlemap_demo_comp.Class;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Doma Umaru on 10/2/2016.
 */

public class cs_FourSquareExplore {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("notifications")
    private List<Notification> notifications;
    @SerializedName("response")
    private Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public class Meta {
        @SerializedName("code")
        private int code;
        @SerializedName("requestId")
        private String requestId;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestid) {
            this.requestId = requestid;
        }
    }

    public class Notification {
        @SerializedName("type")
        private String type;
        @SerializedName("item")
        private Item item;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public class Item {
            @SerializedName("unreadCount")
            private int unreadCount;

            public int getUnreadCount() {
                return unreadCount;
            }

            public void setUnreadCount(int unreadcount) {
                this.unreadCount = unreadcount;
            }
        }
    }

    public class Response {
        @SerializedName("venue")
        private Venue venue;

        public Venue getVenue() {
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

        public class Venue {
            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;
            @SerializedName("contact")
            private Contact contact;
            @SerializedName("location")
            private Location location;
            @SerializedName("canonicalUrl")
            private String canonicalUrl;
            @SerializedName("categories")
            private List<Category> categories;
            @SerializedName("verified")
            private boolean verified;
            @SerializedName("stats")
            private Stat stats;
            @SerializedName("likes")
            private Likes likes;
            @SerializedName("like")
            private boolean like;
            @SerializedName("dislike")
            private boolean dislike;
            @SerializedName("ok")
            private boolean ok;
            @SerializedName("allowMenuUrlEdit")
            private boolean allowMenuUrlEdit;
            @SerializedName("beenHere")
            private BeenHere beenHere;
            @SerializedName("specials")
            private Specials specials;
            @SerializedName("photos")
            private Photos photos;
            @SerializedName("reasons")
            private Reasons reasons;
            @SerializedName("hereNow")
            private HereNow hereNow;
            @SerializedName("createdAt")
            private int createdAt;
            @SerializedName("tips")
            private Tips tips;
            @SerializedName("tags")
            private List<String> tags;
            @SerializedName("shortUrl")
            private String shortUrl;
            @SerializedName("timeZone")
            private String timeZone;
            @SerializedName("listed")
            private Listed listed;
            @SerializedName("pageUpdates")
            private PageUpdate pageUpdates;
            @SerializedName("inbox")
            private Inbox inbox;
            @SerializedName("venueChains")
            private List<VenueChain> venueChains;
            @SerializedName("attributes")
            private Attributes attributes;
            @SerializedName("bestPhoto")
            private BestPhoto bestPhoto;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Contact getContact() {
                return contact;
            }

            public void setContact(Contact contact) {
                this.contact = contact;
            }

            public Location getLocation() {
                return location;
            }

            public void setLocation(Location location) {
                this.location = location;
            }

            public String getCanonicalUrl() {
                return canonicalUrl;
            }

            public void setCanonicalUrl(String canonicalurl) {
                this.canonicalUrl = canonicalurl;
            }

            public List<Category> getCategories() {
                return categories;
            }

            public void setCategories(List<Category> categories) {
                this.categories = categories;
            }

            public boolean getVerified() {
                return verified;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public Stat getStats() {
                return stats;
            }

            public void setStats(Stat stats) {
                this.stats = stats;
            }

            public Likes getLikes() {
                return likes;
            }

            public void setLikes(Likes likes) {
                this.likes = likes;
            }

            public boolean getLike() {
                return like;
            }

            public void setLike(boolean like) {
                this.like = like;
            }

            public boolean getDislike() {
                return dislike;
            }

            public void setDislike(boolean dislike) {
                this.dislike = dislike;
            }

            public boolean getOk() {
                return ok;
            }

            public void setOk(boolean ok) {
                this.ok = ok;
            }

            public boolean getAllowMenuUrlEdit() {
                return allowMenuUrlEdit;
            }

            public void setAllowMenuUrlEdit(boolean allowmenuurledit) {
                this.allowMenuUrlEdit = allowmenuurledit;
            }

            public BeenHere getBeenHere() {
                return beenHere;
            }

            public void setBeenHere(BeenHere beenHere) {
                this.beenHere = beenHere;
            }

            public Specials getSpecials() {
                return specials;
            }

            public void setSpecials(Specials specials) {
                this.specials = specials;
            }

            public Photos getPhotos() {
                return photos;
            }

            public void setPhotos(Photos photos) {
                this.photos = photos;
            }

            public Reasons getReasons() {
                return reasons;
            }

            public void setReasons(Reasons reasons) {
                this.reasons = reasons;
            }

            public HereNow getHereNow() {
                return hereNow;
            }

            public void setHereNow(HereNow hereNow) {
                this.hereNow = hereNow;
            }

            public int getCreatedat() {
                return createdAt;
            }

            public void setCreatedat(int createdAt) {
                this.createdAt = createdAt;
            }

            public Tips getTips() {
                return tips;
            }

            public void setTips(Tips tips) {
                this.tips = tips;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }

            public String getShortUrl() {
                return shortUrl;
            }

            public void setShortUrl(String shortUrl) {
                this.shortUrl = shortUrl;
            }

            public String getTimeZone() {
                return timeZone;
            }

            public void setTimeZone(String timeZone) {
                this.timeZone = timeZone;
            }

            public Listed getListed() {
                return listed;
            }

            public void setListed(Listed listed) {
                this.listed = listed;
            }

            public PageUpdate getPageUpdates() {
                return pageUpdates;
            }

            public void setPageUpdates(PageUpdate pageUpdates) {
                this.pageUpdates = pageUpdates;
            }

            public Inbox getInbox() {
                return inbox;
            }

            public void setInbox(Inbox inbox) {
                this.inbox = inbox;
            }

            public List<VenueChain> getVenueChains() {
                return venueChains;
            }

            public void setVenueChains(List<VenueChain> venueChains) {
                this.venueChains = venueChains;
            }

            public Attributes getAttributes() {
                return attributes;
            }

            public void setAttributes(Attributes attributes) {
                this.attributes = attributes;
            }

            public BestPhoto getBestPhoto() {
                return bestPhoto;
            }

            public void setBestPhoto(BestPhoto bestPhoto) {
                this.bestPhoto = bestPhoto;
            }


            public class Contact {
                @SerializedName("phone")
                private String phone;
                @SerializedName("formattedPhone")
                private String formattedPhone;

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getFormattedPhone() {
                    return formattedPhone;
                }

                public void setFormattedPhone(String formattedphone) {
                    this.formattedPhone = formattedphone;
                }
            }

            public class Location {
                @SerializedName("address")
                private String address;
                @SerializedName("lat")
                private double lat;
                @SerializedName("lng")
                private double lng;
                @SerializedName("labeledLatLngs")
                private List<LabeledLatLng> labeledLatLngs;
                @SerializedName("cc")
                private String cc;
                @SerializedName("city")
                private String city;
                @SerializedName("state")
                private String state;
                @SerializedName("country")
                private String country;
                @SerializedName("formattedAddress")
                private List<String> formattedAddress;

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }

                public List<LabeledLatLng> getLabeledLatLngs() {
                    return labeledLatLngs;
                }

                public void setLabeledLatLngs(List<LabeledLatLng> labeledlatlngs) {
                    this.labeledLatLngs = labeledlatlngs;
                }

                public String getCc() {
                    return cc;
                }

                public void setCc(String cc) {
                    this.cc = cc;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public List<String> getFormattedAddress() {
                    return formattedAddress;
                }

                public void setFormattedAddress(List<String> formattedaddress) {
                    this.formattedAddress = formattedaddress;
                }

                public class LabeledLatLng {
                    @SerializedName("label")
                    private String label;
                    @SerializedName("lat")
                    private double lat;
                    @SerializedName("lng")
                    private double lng;

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }

            public class Category {
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;
                @SerializedName("pluralName")
                private String pluralName;
                @SerializedName("shortName")
                private String shortName;
                @SerializedName("icon")
                private Icon icon;
                @SerializedName("primary")
                private boolean primary;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPluralName() {
                    return pluralName;
                }

                public void setPluralName(String pluralname) {
                    this.pluralName = pluralname;
                }

                public String getShortName() {
                    return shortName;
                }

                public void setShortName(String shortname) {
                    this.shortName = shortname;
                }

                public Icon getIcon() {
                    return icon;
                }

                public void setIcon(Icon icon) {
                    this.icon = icon;
                }

                public boolean getPrimary() {
                    return primary;
                }

                public void setPrimary(boolean primary) {
                    this.primary = primary;
                }

                public class Icon {
                    @SerializedName("prefix")
                    private String prefix;
                    @SerializedName("suffix")
                    private String suffix;

                    public String getPrefix() {
                        return prefix;
                    }

                    public void setPrefix(String prefix) {
                        this.prefix = prefix;
                    }

                    public String getSuffix() {
                        return suffix;
                    }

                    public void setSuffix(String suffix) {
                        this.suffix = suffix;
                    }
                }
            }

            public class Stat {
                @SerializedName("checkinsCount")
                private int checkinsCount;
                @SerializedName("usersCount")
                private int usersCount;
                @SerializedName("tipCount")
                private int tipCount;
                @SerializedName("visitsCount")
                private int visitsCount;

                public int getCheckinsCount() {
                    return checkinsCount;
                }

                public void setCheckinsCount(int checkinscount) {
                    this.checkinsCount = checkinscount;
                }

                public int getUsersCount() {
                    return usersCount;
                }

                public void setUsersCount(int userscount) {
                    this.usersCount = userscount;
                }

                public int getTipCount() {
                    return tipCount;
                }

                public void setTipCount(int tipcount) {
                    this.tipCount = tipcount;
                }

                public int getVisitsCount() {
                    return visitsCount;
                }

                public void setVisitsCount(int visitscount) {
                    this.visitsCount = visitscount;
                }
            }

            public class Likes {
                @SerializedName("count")
                private int count;
                @SerializedName("groups")
                private List<Group> groups;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                }
            }

            public class BeenHere {
                @SerializedName("count")
                private int count;
                @SerializedName("unconfirmedCount")
                private int unconfirmedCount;
                @SerializedName("marked")
                private boolean marked;
                @SerializedName("lastCheckinExpiredAt")
                private int lastCheckinExpiredAt;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getUnconfirmedCount() {
                    return unconfirmedCount;
                }

                public void setUnconfirmedCount(int unconfirmedcount) {
                    this.unconfirmedCount = unconfirmedcount;
                }

                public boolean getMarked() {
                    return marked;
                }

                public void setMarked(boolean marked) {
                    this.marked = marked;
                }

                public int getLastCheckinExpiredAt() {
                    return lastCheckinExpiredAt;
                }

                public void setLastCheckinExpiredAt(int lastcheckinexpiredat) {
                    this.lastCheckinExpiredAt = lastcheckinexpiredat;
                }
            }

            public class Specials {
                @SerializedName("count")
                private int count;
                @SerializedName("items")
                private List<Item> items;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public class Item {
                }
            }

            public class Photos {
                @SerializedName("count")
                private int count;
                @SerializedName("groups")
                private List<Group> groups;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                    @SerializedName("type")
                    private String type;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("count")
                    private int count;
                    @SerializedName("items")
                    private List<Item> items;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public List<Item> getItems() {
                        return items;
                    }

                    public void setItems(List<Item> items) {
                        this.items = items;
                    }

                    public class Item {
                        @SerializedName("id")
                        private String id;
                        @SerializedName("createdAt")
                        private int createdAt;
                        @SerializedName("source")
                        private Source source;
                        @SerializedName("prefix")
                        private String prefix;
                        @SerializedName("suffix")
                        private String suffix;
                        @SerializedName("width")
                        private int width;
                        @SerializedName("height")
                        private int height;
                        @SerializedName("user")
                        private User user;
                        @SerializedName("visibility")
                        private String visibility;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public int getCreatedAt() {
                            return createdAt;
                        }

                        public void setCreatedAt(int createdat) {
                            this.createdAt = createdat;
                        }

                        public Source getSource() {
                            return source;
                        }

                        public void setSource(Source source) {
                            this.source = source;
                        }

                        public String getPrefix() {
                            return prefix;
                        }

                        public void setPrefix(String prefix) {
                            this.prefix = prefix;
                        }

                        public String getSuffix() {
                            return suffix;
                        }

                        public void setSuffix(String suffix) {
                            this.suffix = suffix;
                        }

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }

                        public int getHeight() {
                            return height;
                        }

                        public void setHeight(int height) {
                            this.height = height;
                        }

                        public User getUser() {
                            return user;
                        }

                        public void setUser(User user) {
                            this.user = user;
                        }

                        public String getVisibility() {
                            return visibility;
                        }

                        public void setVisibility(String visibility) {
                            this.visibility = visibility;
                        }

                        public class Source {
                            @SerializedName("name")
                            private String name;
                            @SerializedName("url")
                            private String url;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public class User {
                            @SerializedName("id")
                            private String id;
                            @SerializedName("firstName")
                            private String firstName;
                            @SerializedName("lastName")
                            private String lastName;
                            @SerializedName("gender")
                            private String gender;
                            @SerializedName("photo")
                            private Photo photo;
                            @SerializedName("isAnonymous")
                            private boolean isAnonymous;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getFirstName() {
                                return firstName;
                            }

                            public void setFirstName(String firstName) {
                                this.firstName = firstName;
                            }

                            public String getLastName() {
                                return lastName;
                            }

                            public void setLastName(String lastName) {
                                this.lastName = lastName;
                            }

                            public String getGender() {
                                return gender;
                            }

                            public void setGender(String gender) {
                                this.gender = gender;
                            }

                            public Photo getPhoto() {
                                return photo;
                            }

                            public void setPhoto(Photo photo) {
                                this.photo = photo;
                            }

                            public boolean getAnonymous() {
                                return isAnonymous;
                            }

                            public void setAnonymous(boolean anonymous) {
                                this.isAnonymous = anonymous;
                            }

                            public class Photo {
                                @SerializedName("prefix")
                                private String prefix;
                                @SerializedName("suffix")
                                private String suffix;

                                public String getPrefix() {
                                    return prefix;
                                }

                                public void setPrefix(String prefix) {
                                    this.prefix = prefix;
                                }

                                public String getSuffix() {
                                    return suffix;
                                }

                                public void setSuffix(String suffix) {
                                    this.suffix = suffix;
                                }
                            }
                        }
                    }
                }
            }

            public class Reasons {
                @SerializedName("count")
                private int count;
                @SerializedName("items")
                private List<Item> items;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public class Item {
                }
            }

            public class HereNow {
                @SerializedName("count")
                private int count;
                @SerializedName("summary")
                private String summary;
                @SerializedName("groups")
                private List<Group> groups;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                }
            }

            public class Tips {
                @SerializedName("count")
                private int count;
                @SerializedName("groups")
                private List<Group> groups;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                    @SerializedName("type")
                    private String type;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("count")
                    private int count;
                    @SerializedName("items")
                    private List<Item> items;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public List<Item> getItems() {
                        return items;
                    }

                    public void setItems(List<Item> items) {
                        this.items = items;
                    }

                    public class Item {
                    }
                }
            }

            public class Listed {
                @SerializedName("count")
                private int count;
                @SerializedName("groups")
                private List<Group> groups;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                }
            }

            public class PageUpdate {
                @SerializedName("count")
                private int count;
                @SerializedName("items")
                private List<Item> items;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public class Item {
                }
            }

            public class Inbox {
                @SerializedName("count")
                private int count;
                @SerializedName("items")
                private List<Item> items;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public class Item {
                }
            }

            public class VenueChain {
            }

            public class Attributes {
                @SerializedName("groups")
                private List<Group> groups;

                public List<Group> getGroups() {
                    return groups;
                }

                public void setGroups(List<Group> groups) {
                    this.groups = groups;
                }

                public class Group {
                    @SerializedName("type")
                    private String type;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("summary")
                    private String summary;
                    @SerializedName("count")
                    private int count;
                    @SerializedName("items")
                    private List<Item> items;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSummary() {
                        return summary;
                    }

                    public void setSummary(String summary) {
                        this.summary = summary;
                    }

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public List<Item> getItems() {
                        return items;
                    }

                    public void setItems(List<Item> items) {
                        this.items = items;
                    }

                    public class Item {
                        @SerializedName("displayName")
                        private String displayName;
                        @SerializedName("displayValue")
                        private String displayValue;
                        @SerializedName("priceTier")
                        private int priceTier;

                        public String getDisplayName() {
                            return displayName;
                        }

                        public void setDisplayName(String displayName) {
                            this.displayName = displayName;
                        }

                        public String getDisplayValue() {
                            return displayValue;
                        }

                        public void setDisplayValue(String displayValue) {
                            this.displayValue = displayValue;
                        }

                        public int getPriceTier() {
                            return priceTier;
                        }

                        public void setPriceTier(int priceTier) {
                            this.priceTier = priceTier;
                        }
                    }
                }
            }

            public class BestPhoto {
                @SerializedName("id")
                private String id;
                @SerializedName("createdAt")
                private int createdAt;
                @SerializedName("source")
                private Source source;
                @SerializedName("prefix")
                private String prefix;
                @SerializedName("suffix")
                private String suffix;
                @SerializedName("width")
                private int width;
                @SerializedName("height")
                private int height;
                @SerializedName("visibility")
                private String visibility;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(int createdAt) {
                    this.createdAt = createdAt;
                }

                public Source getSource() {
                    return source;
                }

                public void setSource(Source source) {
                    this.source = source;
                }

                public String getPrefix() {
                    return prefix;
                }

                public void setPrefix(String prefix) {
                    this.prefix = prefix;
                }

                public String getSuffix() {
                    return suffix;
                }

                public void setSuffix(String suffix) {
                    this.suffix = suffix;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getVisibility() {
                    return visibility;
                }

                public void setVisibility(String visibility) {
                    this.visibility = visibility;
                }

                public class Source {
                    @SerializedName("name")
                    private String name;
                    @SerializedName("url")
                    private String url;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }
}
