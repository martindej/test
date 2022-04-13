var geoip = require('geoip-lite');

// Index
app.get('/', async(req,res) => {
  const ip = (req.headers['x-forwarded-for'] || req.connection.remoteAddress).split(',')[0];
  var geo = geoip.lookup(ip);
  
  //Create your Parse Object
  const userInfos = new Parse.Object("UserInfos");

  //Define its attributes
  userInfos.set("ipAddress", ip);
  userInfos.set("country", geo.country);
  userInfos.set("region", geo.region);
  userInfos.set("city", geo.city);
  userInfos.set("timezone", geo.timezone)
  try{
      //Save the Object
      let result = await userInfos.save()
      console.log('New object created with objectId: ' + result.id);
  }catch(error){
      console.log('Failed to create new object, with error code: ' + error.message);
  }
  
  const pipeline = [
    { group : {objectId:"$ipAddress", count:{$sum:1}}},
    { sort: {count:-1}} 
  ];
  
  query = new Parse.Query("UserInfos");
  query.limit(100);
  
  query.descending("createdAt");
  query.find().then(function(allInfos){
      if(allInfos){
        
        console.log(JSON.stringify(allInfos))
        
        queryBis = new Parse.Query("UserInfos");
        queryBis.aggregate(pipeline).then(function(counts){
            if(counts){
              res.render('index', { ipAddress: ip, geo: geo, allInfos: allInfos, ipCounts:counts });
            }
        }).catch(function(error){
            console.log("Error: " + error.code + " " + error.message);       
        });
        
      } else {
         console.log("Nothing found, please try again");
      }
  }).catch(function(error){
      console.log("Error: " + error.code + " " + error.message);       
  });

  
});